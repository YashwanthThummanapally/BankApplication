package test;
import java.sql.*;
import java.util.Date;
public class TransferAmountDAO {
	private int k;
	public int transfer(Double transferAmount, CustomerBean homeAccount, Long beneficieryAccNo) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement("SELECT * FROM BANKACCOUNT WHERE ACCNO=?");
			select.setLong(1, beneficieryAccNo);
			ResultSet rs = select.executeQuery();
			if(rs.next()) {
				double balance = homeAccount.getBalance();
				if(transferAmount<=balance && transferAmount>0) {
					PreparedStatement update = con.prepareStatement("UPDATE BANKACCOUNT SET ACCBALANCE=ACCBALANCE+? WHERE ACCNO=?");
					con.setAutoCommit(false);
					Savepoint sp = con.setSavepoint();
					
					update.setDouble(1, -transferAmount);
					update.setLong(2, homeAccount.getAccountNumber());
					int k1 = update.executeUpdate(); 
					
					update.setDouble(1, +transferAmount);
					update.setLong(2, beneficieryAccNo);
					int k2 = update.executeUpdate();
					
					if(k1==1 && k2==1) {
						PreparedStatement insert = con.prepareStatement("INSERT INTO TRANSACTION VALUES(SQ1.NEXTVAL,?,?,?,?)");
						
						insert.setLong(1, homeAccount.getAccountNumber());
						insert.setLong(2, beneficieryAccNo);
						insert.setDouble(3, transferAmount);
						// Create a new java.util.Date object to get the current date and time
			            Date currentDate = new Date();
			            // Set the parameter value to the current date and time
			            insert.setTimestamp(4, new java.sql.Timestamp(currentDate.getTime()));
			            int k3 = insert.executeUpdate();
						if(k3>0) {
							con.commit();
							k = 1;
						}else {
							con.rollback(sp);
						}
					}else {
						con.rollback(sp);
					}					
				}
			}
		}catch(Exception e) {e.printStackTrace(); }
		return k;
	}
}