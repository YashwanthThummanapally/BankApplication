package test;
import java.sql.*;
import java.util.*;
public class ViewAllCustomersDAO {
	private ArrayList<CustomerBean> customers = new ArrayList<>();
	public ArrayList<CustomerBean> selectAll(){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement("SELECT * FROM BANKACCOUNT");
			ResultSet rs = select.executeQuery();
			while(rs.next()) {
				CustomerBean cust = new CustomerBean();
				cust.setAccountNumber(rs.getLong(1));
				cust.setHolderName(rs.getString(2));
				cust.setBalance(rs.getDouble(3));
				cust.setAccountType(rs.getString(4));
				customers.add(cust);
			}
		}catch(Exception e) {e.printStackTrace();}
		return customers;
	}
}