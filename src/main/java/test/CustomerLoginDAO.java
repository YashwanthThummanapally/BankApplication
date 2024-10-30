package test;
import java.sql.*;
public class CustomerLoginDAO {
	private CustomerBean customer;
	public CustomerBean customerLogin(Long accountNumber, String holderName) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement("SELECT * FROM BANKACCOUNT WHERE ACCNO=? AND ACCHOLDERNAME=?");
			select.setLong(1, accountNumber);
			select.setString(2, holderName);
			ResultSet rs = select.executeQuery();
			if(rs.next()) {
				customer = new CustomerBean();
				customer.setAccountNumber(rs.getLong(1));
				customer.setHolderName(rs.getString(2));
				customer.setBalance(rs.getDouble(3));
				customer.setAccountType(rs.getString(4));
			}
		}catch(Exception e) {e.printStackTrace();}
		return customer;
	}
}