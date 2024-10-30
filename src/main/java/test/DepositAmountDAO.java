package test;
import java.sql.*;
import java.util.Date;
 
public class DepositAmountDAO {
	private int k;
	public int deposit(Double amount, Long accountNumber) {
		try {
			Connection con = DBConnection.getCon();
			
			con.setAutoCommit(false);
			Savepoint sp = con.setSavepoint();
			
			PreparedStatement update = con.prepareStatement("UPDATE BANKACCOUNT SET ACCBALANCE=ACCBALANCE+? WHERE ACCNO=?");
			update.setDouble(1, amount);
			update.setLong(2, accountNumber);
			int k1 = update.executeUpdate();
			
			if(k1>0) {
				PreparedStatement insert = con.prepareStatement("INSERT INTO TRANSACTION VALUES(SQ1.NEXTVAL,?,?,?,?)");
				insert.setLong(1, accountNumber); // homeAccNo
				insert.setLong(2, accountNumber); // BenAccNo
				insert.setDouble(3, amount);
				// Create a new java.util.Date object to get the current date and time
	            Date currentDate = new Date();
	            // Set the parameter value to the current date and time
	            insert.setTimestamp(4, new java.sql.Timestamp(currentDate.getTime()));
	            
	            int k2 = insert.executeUpdate();
				if(k2>0) {
					con.commit();
					k = 1;
				}else {
					con.rollback(sp);
				}				
			}else {
				con.rollback(sp);
			}
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}