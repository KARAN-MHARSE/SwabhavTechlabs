package com.aurionpro.bms.util;

import java.awt.desktop.UserSessionEvent.Reason;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aurionpro.bms.dao.TransactionDao;
import com.aurionpro.bms.dto.TransactionDto;
import com.aurionpro.bms.dto.UserAccountDTO;
import com.aurionpro.bms.models.Account;
import com.aurionpro.bms.models.Document;
import com.aurionpro.bms.models.User;
import com.aurionpro.bms.properties.AccountStatus;
import com.aurionpro.bms.properties.AccountType;
import com.aurionpro.bms.properties.DocumentType;
import com.aurionpro.bms.properties.Gender;
import com.aurionpro.bms.properties.TransactionStatus;

public class ResultSetMapperUtil {
	
	public static List<TransactionDto> toTransactionDTOList(ResultSet rs) throws SQLException{
		List<TransactionDto> transactions = new ArrayList<>();
		  while(rs.next()) {
			  TransactionDto dto = new TransactionDto();
	          dto.setTransactionId(rs.getInt("id"));
	          dto.setFromAccountNumber(rs.getString("from_account"));
	          dto.setSenderName(rs.getString("from_user"));
	          dto.setToAccountNumber(rs.getString("to_account"));
	          dto.setReceiverName(rs.getString("to_user"));
	          dto.setAmount(rs.getDouble("amount"));
	          dto.setMessage(rs.getString("message"));
	          dto.setStatus(TransactionStatus.valueOf(rs.getString("status")));
	          dto.setCreatedAt(rs.getTimestamp("created_at"));
	          
	          transactions.add(dto);
		  }
		  return transactions;

          
	}
	
	public static List<UserAccountDTO> toUserAccountDTOList(ResultSet result) throws SQLException {
		Map<Integer, UserAccountDTO> map = new HashMap<>();
		while(result.next()) {
			
			int accountId = result.getInt("accountId");
			
			UserAccountDTO dto = map.get(accountId);
			
			
			if(dto==null) {
				User user = new User();
				user.setId(result.getInt("userId"));
				user.setName(result.getString("userName"));
				user.setAddress(result.getString("address"));
				user.setEmail(result.getString("email"));
				user.setMobile(result.getLong("mobile"));
				user.setAdharNo(result.getLong("adharNo"));
				user.setPanNo(result.getString("panNo"));
				
				
				Account account = new Account();
				account.setId(result.getInt("accountId"));
				account.setAccountNumber(result.getString("account_number"));
				account.setType(AccountType.valueOf(result.getString("accountType")) );
				account.setBalance(result.getDouble("balance"));
				account.setCreatedAt(result.getTimestamp("accountCreatedAt"));
				account.setAccountStatus(AccountStatus.valueOf(result.getString("account_status")));
				
				dto = new UserAccountDTO(user,account,new ArrayList<>());
				map.put(accountId, dto);
			}
			
		
			Document document = new Document();
			document.setFile(result.getBytes("doc_file"));
			document.setName(result.getString("doc_name"));
			if(result.getString("doc_type") != null) {
				document.setType(DocumentType.valueOf(result.getString("doc_type")));
			}
			dto.getDocuments().add(document);
		}
		return new ArrayList<>(map.values());
	}

}
