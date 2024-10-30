package test;
import java.sql.*;
public class DeleteCustomerDAO {
	private int k;
	public int deleteCustomerBean(CustomerBean cust) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement delete = con.prepareStatement("DELETE FROM BANKACCOUNT WHERE ACCNO=?");
			delete.setLong(1, cust.getAccountNumber());
			k = delete.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}