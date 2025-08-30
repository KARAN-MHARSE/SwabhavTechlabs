package com.aurionpro.bms.dao;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.print.Doc;
import javax.servlet.http.Part;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.aurionpro.bms.database.Database;
import com.aurionpro.bms.dto.UserAccountDTO;
import com.aurionpro.bms.exceptions.DatabaseException;
import com.aurionpro.bms.models.Account;
import com.aurionpro.bms.models.Document;
import com.aurionpro.bms.models.Stats;
import com.aurionpro.bms.models.User;
import com.aurionpro.bms.properties.AccountStatus;
import com.aurionpro.bms.properties.AccountType;
import com.aurionpro.bms.properties.DocumentType;
import com.aurionpro.bms.util.ResultSetMapperUtil;

public class AccountDao {
	private Connection connection;

	public AccountDao() {
		this.connection = Database.getConnection();
	}

	public boolean uploadDocument(Connection connection, int userId, Document document) {
		String sql = "insert into document" + "(user_id,doc_file,doc_name,doc_type)" + "values(?,?,?,?);";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, userId);
			statement.setBytes(2, document.getFile());
			statement.setString(3, document.getName());
			statement.setString(4, document.getType().toString());

			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			throw new DatabaseException("Error while uploading document", e);
		}
	}

	public List<Account> getAccountsByUserId(int userId) {
		List<Account> accounts = new LinkedList<>();

		String sql = "select * from account where user_id = ?;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, userId);

			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					int id = result.getInt("id");
					String accountNumber = result.getString("account_number");
					AccountType type = AccountType.valueOf(result.getString("type"));
					double balance = result.getDouble("balance");
					Timestamp createdAt = result.getTimestamp("created_at");
					AccountStatus isApproved = AccountStatus.valueOf(result.getString("account_status"));

					Account account = new Account(id, userId, accountNumber, type, balance, isApproved, createdAt);
					accounts.add(account);

				}
			}
			return accounts;
		} catch (SQLException e) {
			throw new DatabaseException("Database error", e);
		}
	}

	public boolean requestForNewAccount(int userId, Long adharNo, String panNo, AccountType accountType,
			List<Document> documents) {

		try {
			connection.setAutoCommit(false);

			for (Document document : documents) {
				boolean isUploaded = uploadDocument(connection, userId, document);
				if (!isUploaded)
					throw new DatabaseException("Something went wrong while upload document " + document.getName());
			}

			String accountNumber = "TDCB000" + userId + (int) (Math.random() * 1000);

			String sql = "SELECT request_for_new_account(?, ?, ?, ?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setInt(1, userId);
				statement.setString(2, accountType.toString());
				statement.setString(3, accountNumber);
				statement.setLong(4, adharNo);
				statement.setString(5, panNo);

				ResultSet rs = statement.executeQuery();
				if (!rs.next()) {
					throw new DatabaseException("Error while sending request");
				}
				boolean success = rs.getBoolean(1);
				if (success) {
					connection.commit();
					return success;
				}
				connection.rollback();
				return success;

			}

		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				throw new DatabaseException(e.getMessage());
			}
		}

	}

	public boolean approvedOrRejectPendingAccount(String accountNumber, boolean isApproved) {
		String sql = "update account set account_status = ? where account_number=?;";
		String accountStatus = isApproved ? "Approved" : "Rejected";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, accountStatus);
			statement.setString(2, accountNumber);

			int updatedRows = statement.executeUpdate();
			if (updatedRows <= 0)
				throw new RuntimeException("Something went wrong");
			return updatedRows > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<UserAccountDTO> getAllUserAccounts() {
		Map<Integer, UserAccountDTO> map = new HashMap<>();

		String sql = "select u.id as userId,u.name as userName,u.address,u.email,u.mobile,u.adhar_no as adharNo,u.pan_no as panNo,u.role,u.isactive,a.id as accountId,"
				+ "	a.account_number,a.type as accountType,a.balance,a.account_status,a.created_at as accountCreatedAt,d.doc_file,d.doc_name,d.doc_type	"
				+ "from " + "users u " + "join account a on u.id = a.user_id "
				+ "left join document d on u.id = d.user_id ";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet result = statement.executeQuery();

			List<UserAccountDTO> userAccountDetails = ResultSetMapperUtil.toUserAccountDTOList(result);
			return userAccountDetails;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
	}

	public boolean createNewUserAccount(UserAccountDTO userAccountDTO) {

		try {
			connection.setAutoCommit(false);

			String sql = "insert into users(name,address,email,mobile,adhar_no,pan_no,password)"
					+ "values (?,?,?,?,?,?,?);";

//			Create user account first
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, userAccountDTO.getName());
				statement.setString(2, userAccountDTO.getAddress());
				statement.setString(3, userAccountDTO.getEmail());
				statement.setLong(4, userAccountDTO.getMobile());
				statement.setLong(5, userAccountDTO.getAdhar());
				statement.setString(6, userAccountDTO.getPan());
				statement.setString(7, userAccountDTO.getName());

				int updatedRows = statement.executeUpdate();
				if (updatedRows <= 0)
					throw new DatabaseException("Something went wrong while inserting user");
			}

			int userId;
			sql = "select id from users where email =?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, userAccountDTO.getEmail());
				ResultSet result = statement.executeQuery();
				if (!result.next())
					throw new DatabaseException("Something went wrong while inserting user");
				userId = result.getInt("id");
			}

			for (Document document : userAccountDTO.getDocuments()) {
				sql = "insert into document(user_id,doc_file,doc_name,doc_type) " + "values (?,?,?,?);";
				try (PreparedStatement statement = connection.prepareStatement(sql)) {
					statement.setInt(1, userId);
					statement.setBytes(2, document.getFile());
					statement.setString(3, document.getName());
					statement.setString(4, document.getType().toString());

					int updatedRows = statement.executeUpdate();
					if (updatedRows <= 0)
						throw new DatabaseException("Something went wrong while inserting account");

				}
			}

			sql = "insert into account (user_id,account_number,type,balance,account_status) " + "values (?,?,?,?,?);";

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				String accountNumber = "TDCB000" + userId + (int) (Math.random() * 1000);
				statement.setInt(1, userId);
				statement.setString(2, accountNumber);
				statement.setString(3, "Saving");
				statement.setDouble(4, userAccountDTO.getBalance());
				statement.setString(5, userAccountDTO.getAccountStatus().toString());

				int updatedRows = statement.executeUpdate();
				if (updatedRows <= 0)
					throw new DatabaseException("Something went wrong while inserting account");

			}
			connection.commit();
			return true;
		} catch (SQLException | RuntimeException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new DatabaseException("Error creating new account", e);
			}
			throw new DatabaseException("Error creating new account", e);
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				throw new DatabaseException("Error creating new account", e);
			}
		}
	}

	public List<UserAccountDTO> getAllPendingAccounts() {
		Map<Integer, UserAccountDTO> map = new HashMap<>();

		String sql = "select u.id as userId,u.name as userName,u.address,u.email,u.mobile,u.adhar_no as adharNo,u.pan_no as panNo,u.role,u.isactive,a.id as accountId,"
				+ "	a.account_number,a.type as accountType,a.balance,a.account_status,a.created_at as accountCreatedAt,d.doc_file,d.doc_name,d.doc_type	"
				+ "from " + "users u " + "join account a on u.id = a.user_id "
				+ "left join document d on u.id = d.user_id "
				+ "where a.account_status = 'Pending' and u.isactive = true";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet result = statement.executeQuery();

			List<UserAccountDTO> userAccountDetails = ResultSetMapperUtil.toUserAccountDTOList(result);
			return userAccountDetails;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException(e.getMessage());
		}
	}

	public UserAccountDTO getUserAccountDetailsByUserId(int userId) {
		String sql = "select \r\n"
				+ "	u.id as userId,u.name as userName,u.address,u.email,u.mobile,u.adhar_no as adharNo,u.pan_no as panNo,u.role,u.isactive,\r\n"
				+ "	a.id as accountId,a.account_number,a.type as accountType,a.balance,a.account_status,a.created_at as accountCreatedAt,\r\n"
				+ "	d.doc_file,d.doc_name,d.doc_type\r\n" + "from \r\n" + "users u \r\n"
				+ "join account a on u.id = a.user_id \r\n" + "left join document d on u.id = d.user_id\r\n"
				+ "where u.id=?;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, userId);

			ResultSet result = statement.executeQuery();
			List<UserAccountDTO> userAccountDetailsList = ResultSetMapperUtil.toUserAccountDTOList(result);
			if (userAccountDetailsList != null && !userAccountDetailsList.isEmpty()) {
				return userAccountDetailsList.get(0);
			}

		} catch (SQLException e) {
			e.printStackTrace();
//			throe new DatabaseException()
		}
		return null;
	}

	public UserAccountDTO getUserAccountDetailsByAccountNumber(String accountNumber) {
		String sql = "select \r\n"
				+ "	u.id as userId,u.name as userName,u.address,u.email,u.mobile,u.adhar_no as adharNo,u.pan_no as panNo,u.role,u.isactive,\r\n"
				+ "	a.id as accountId,a.account_number,a.type as accountType,a.balance,a.account_status,a.created_at as accountCreatedAt,\r\n"
				+ "	d.doc_file,d.doc_name,d.doc_type\r\n" + "from \r\n" + "users u \r\n"
				+ "join account a on u.id = a.user_id \r\n" + "left join document d on u.id = d.user_id\r\n"
				+ "where a.account_number = ?;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, accountNumber);

			ResultSet result = statement.executeQuery();
			List<UserAccountDTO> userAccountDetailsList = ResultSetMapperUtil.toUserAccountDTOList(result);
			if (userAccountDetailsList != null && !userAccountDetailsList.isEmpty()) {
				return userAccountDetailsList.get(0);
			}

		} catch (SQLException e) {
			e.printStackTrace();
//			throe new DatabaseException()
		}
		return null;
	}
	
	public Stats getStats() throws SQLException {
		String sql = "select \r\n"
				+ "    (select count(id) from users) as total_customers,\r\n"
				+ "    (select count(account_number) from account) as total_approved_accounts,\r\n"
				+ "	(select count(account_number) from account where account_status='Pending') as total_pending_accounts,\r\n"
				+ "    (select count(id) from transaction where status='Successfull') as total_success_transactions,\r\n"
				+ "	(select count(id) from transaction where status='Failed') as total_failed_transactions;";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			ResultSet set = statement.executeQuery();
			
			Stats stats = new Stats();
			if(set.next()) {
				stats.setTotalCustomers(set.getInt("total_customers"));
				stats.setTotalApprovedAccounts(set.getInt("total_approved_accounts"));
				stats.setTotalPendingAccounts(set.getInt("total_pending_accounts"));
				stats.setTotalSuccessTransaction(set.getInt("total_success_transactions"));
				stats.setTotalFailedTransaction(set.getInt("total_failed_transactions"));
			}
			return stats;
		}
	}

	public boolean blockAccount(String accountNumber,String status) {
		String query = "update account set account_status = ? where account_number = ?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setString(1, status);
			statement.setString(2, accountNumber);
			
			int updatedRows = statement.executeUpdate();
			return updatedRows >0; 
		}
		catch (SQLException e) {
			throw new DatabaseException("Something went wrong while block the account");
		}
	}

}
