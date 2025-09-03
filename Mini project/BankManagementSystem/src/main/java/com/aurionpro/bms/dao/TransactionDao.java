package com.aurionpro.bms.dao;

import java.awt.Taskbar.State;
import java.beans.Statement;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.aurionpro.bms.database.Database;
import com.aurionpro.bms.dto.TransactionDto;
import com.aurionpro.bms.exceptions.DatabaseException;
import com.aurionpro.bms.exceptions.InsufficientBalanceException;
import com.aurionpro.bms.exceptions.TransactionNotFoundException;
import com.aurionpro.bms.models.Transaction;
import com.aurionpro.bms.properties.AccountStatus;
import com.aurionpro.bms.properties.TransactionStatus;
import com.aurionpro.bms.util.ResultSetMapperUtil;

public class TransactionDao {
	private Connection connection;

	public TransactionDao() {
		connection = Database.getConnection();
	}

	public boolean insertTransaction(Connection connection, Transaction transaction, TransactionStatus status)
			throws SQLException {

		String transactionQuery = "insert into transaction\r\n"
				+ "(from_account,to_account,amount,message,status) values\r\n" + "(?,?,?,?,?);";
		try (PreparedStatement statement3 = connection.prepareStatement(transactionQuery)) {
			statement3.setString(1, transaction.getFromAccount());
			statement3.setString(2, transaction.getToAccount());
			statement3.setDouble(3, transaction.getAmount());
			statement3.setString(4, transaction.getMessage());
			statement3.setString(5, status.toString());

			int insertedRows = statement3.executeUpdate();
			return insertedRows > 0;

		}
	}

	public boolean transfer(Transaction transaction,String password) {

		try {
			
			connection.setAutoCommit(false);
			
			String checkPasswordQuery = "select 1 from users where password=? and\r\n"
					+ "id = (\r\n"
					+ "select user_id from account where account_number = ? and account_status = ?);";
			try(PreparedStatement statement = connection.prepareStatement(checkPasswordQuery)){
				statement.setString(1, password);
				statement.setString(2, transaction.getFromAccount());
				statement.setString(3, AccountStatus.Approved.toString());
				
				ResultSet set = statement.executeQuery();
				if(!set.next()) throw new RuntimeException("Invalid password or account may be blocked so check first");
			}
			
			String senderActiveQuery = "select 1 from\r\n"
					+ "users u \r\n"
					+ "join account a on u.id = a.user_id\r\n"
					+ "where a.account_number = ? and u.isActive = true and a.account_status='Approved';";
			try(PreparedStatement statement = connection.prepareStatement(senderActiveQuery)){
				statement.setString(1, transaction.getToAccount());
				ResultSet result = statement.executeQuery();
				if(!result.next()) throw new RuntimeException("Receiver id is blocked or not active");
			}
			

			String getQuery = "select balance from account where account_number=?;";

			try (PreparedStatement getStatement = connection.prepareStatement(getQuery)) {
				connection.setAutoCommit(false);

				getStatement.setString(1, transaction.getFromAccount());
				ResultSet balanceResult = getStatement.executeQuery();
				if (!balanceResult.next()) {
					return false;
				}

				double balance = balanceResult.getDouble("balance");
				if (balance < transaction.getAmount()) {
					throw new InsufficientBalanceException();
				}

			}

			String insertMoneyQuery = "update account set balance = balance+? where account_number =?;";
			try (PreparedStatement statement = connection.prepareStatement(insertMoneyQuery)) {
				statement.setDouble(1, transaction.getAmount());
				statement.setString(2, transaction.getToAccount());

				int updatedRows = statement.executeUpdate();
				if (updatedRows <= 0)
					throw new DatabaseException("Something went wrong while crediting amount");
			}

			String removeMoneyQuery = "update account set balance = balance-? where account_number =?;";
			try (PreparedStatement statement2 = connection.prepareStatement(removeMoneyQuery)) {
				statement2.setDouble(1, transaction.getAmount());
				statement2.setString(2, transaction.getFromAccount());

				int updtatedRows2 = statement2.executeUpdate();
				if (updtatedRows2 <= 0)
					throw new DatabaseException("Something went wrong while debeting amount");
			}
			insertTransaction(connection, transaction, TransactionStatus.Successfull);
			connection.commit();
			return true;
		}

		catch (SQLException | InsufficientBalanceException | DatabaseException  e) {
			try {
				connection.rollback();
				transaction.setMessage(e.getMessage());
				insertTransaction(connection, transaction, TransactionStatus.Failed);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} 
		catch (Exception e) {
			try {
				connection.rollback();
				transaction.setMessage(e.getMessage());
				insertTransaction(connection, transaction, TransactionStatus.Failed);
				throw new RuntimeException(e.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;

	}

	public List<TransactionDto> getAllTransaction() {
		String sql = "SELECT \r\n" + "t.id,\r\n" + "    t.from_account,fu.name AS from_user,\r\n"
				+ "    t.to_account,tu.name AS to_user,\r\n" + "    t.amount,t.message,\r\n"
				+ "    t.status,t.created_at\r\n" + "FROM transaction t\r\n"
				+ "JOIN account fa ON t.from_account = fa.account_number\r\n"
				+ "JOIN users fu ON fu.id = fa.user_id\r\n" + "JOIN account ta ON t.to_account = ta.account_number\r\n"
				+ "JOIN users tu ON tu.id = ta.user_id;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet result = statement.executeQuery();

			return ResultSetMapperUtil.toTransactionDTOList(result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Something went wrong", e);
		}
	}

	public List<TransactionDto> getTransactionsByUserId(int userId) {
		String sql = "SELECT \r\n" + "t.id,\r\n" + "    t.from_account,fu.name AS from_user,\r\n"
				+ "    t.to_account,tu.name AS to_user,\r\n" + "    t.amount,t.message,\r\n"
				+ "    t.status,t.created_at\r\n" + "FROM transaction t\r\n"
				+ "JOIN account fa ON t.from_account = fa.account_number\r\n"
				+ "JOIN users fu ON fu.id = fa.user_id\r\n" + "JOIN account ta ON t.to_account = ta.account_number\r\n"
				+ "JOIN users tu ON tu.id = ta.user_id\r\n" + "where fu.id=? or tu.id=? " + "order by created_at desc;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, userId);
			statement.setInt(2, userId);
			ResultSet result = statement.executeQuery();

			return ResultSetMapperUtil.toTransactionDTOList(result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Something went wrong", e);
		}
	}

	public List<TransactionDto> getTransactionsByStatus(TransactionStatus status) {
		String sql = "SELECT \r\n" + "t.id,\r\n" + "    t.from_account,fu.name AS from_user,\r\n"
				+ "    t.to_account,tu.name AS to_user,\r\n" + "    t.amount,t.message,\r\n"
				+ "    t.status,t.created_at\r\n" + "FROM transaction t\r\n"
				+ "JOIN account fa ON t.from_account = fa.account_number\r\n"
				+ "JOIN users fu ON fu.id = fa.user_id\r\n" + "JOIN account ta ON t.to_account = ta.account_number\r\n"
				+ "JOIN users tu ON tu.id = ta.user_id\r\n" + "where t.status=?;";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, status.toString());
			ResultSet result = statement.executeQuery();

			return ResultSetMapperUtil.toTransactionDTOList(result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Something went wrong", e);
		}
	}

	public boolean creditAmount(String accountNumber, double amount, String message) {
		String insertMoneyQuery = "update account set balance = balance+? where account_number =?;";
		try {
			connection.setAutoCommit(false);

			try (PreparedStatement statement = connection.prepareStatement(insertMoneyQuery)) {
				statement.setDouble(1, amount);
				statement.setString(2, accountNumber);

				int updatedRows = statement.executeUpdate();
				if (updatedRows <= 0)
					throw new DatabaseException("Something went wrong while crediting amount");
			}

			String transactionQuery = "insert into transaction\r\n"
					+ "(from_account,to_account,amount,message,status) values\r\n" + "(?,?,?,?,?);";

			try (PreparedStatement statement = connection.prepareStatement(transactionQuery)) {
				statement.setString(1, accountNumber);
				statement.setString(2, "TDCB00000");
				statement.setDouble(3, amount);
				statement.setString(4, message);
				statement.setString(5, TransactionStatus.Successfull.toString());

				int updatedRows = statement.executeUpdate();
				if (updatedRows <= 0)
					throw new DatabaseException("Something went wrong while crediting amount");
				connection.commit();
				return true;
			}

		} catch (SQLException | RuntimeException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new DatabaseException(e.getMessage());
			}
			throw new DatabaseException(e.getMessage());
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				throw new DatabaseException(e.getMessage());

			}
		}
	}

	public boolean debitAmount(String accountNumber, double amount, String message) {
		
		try {
			connection.setAutoCommit(false);
			
			double balance = 0;
			String selectQuery = "select balance from account where account_number = ?";
			
			try(PreparedStatement statement = connection.prepareStatement(selectQuery)){
				statement.setString(1,accountNumber);
				
				ResultSet result = statement.executeQuery();
				if(!result.next()) throw new RuntimeException("Insufficient account balance");
				balance = result.getDouble("balance");
				if(balance < amount) throw new RuntimeException("Insufficient account balance");
			}
			
			String insertMoneyQuery = "update account set balance = balance-? where account_number =?;";
			try (PreparedStatement statement = connection.prepareStatement(insertMoneyQuery)) {
				statement.setDouble(1, amount);
				statement.setString(2, accountNumber);

				int updatedRows = statement.executeUpdate();
				if (updatedRows <= 0)
					throw new DatabaseException("Something went wrong while crediting amount");
			}

			String transactionQuery = "insert into transaction\r\n"
					+ "(from_account,to_account,amount,message,status) values\r\n" + "(?,?,?,?,?);";

			try (PreparedStatement statement = connection.prepareStatement(transactionQuery)) {
				statement.setString(1, "TDCB00000");
				statement.setString(2, accountNumber);
				statement.setDouble(3, amount);
				statement.setString(4, message);
				statement.setString(5, TransactionStatus.Successfull.toString());

				int updatedRows = statement.executeUpdate();
				if (updatedRows <= 0)
					throw new DatabaseException("Something went wrong while crediting amount");
				connection.commit();
				return true;
			}
		} catch (SQLException | RuntimeException e) {
			try {
				connection.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				throw new DatabaseException(e.getMessage());
			}
			throw new DatabaseException(e.getMessage());
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				throw new DatabaseException(e.getMessage());

			}
		}
	}

}