package test;
import java.sql.*;
public class AddCustomerDAO {
	private int k;
	public int insertCustomer(CustomerBean cust) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement insert = con.prepareStatement("INSERT INTO BANKACCOUNT VALUES(?,?,?,?)");
			insert.setLong(1, cust.getAccountNumber());
			insert.setString(2, cust.getHolderName());
			insert.setDouble(3, cust.getBalance());
			insert.setString(4, cust.getAccountType());
			k = insert.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}