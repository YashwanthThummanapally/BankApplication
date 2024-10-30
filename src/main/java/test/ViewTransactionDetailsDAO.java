package test;
import java.sql.*;
import java.util.*;
public class ViewTransactionDetailsDAO {
	private ArrayList<TransactionBean> transactions = new ArrayList<>();
	public ArrayList<TransactionBean> viewTransactions() {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement("SELECT * FROM TRANSACTION");
			ResultSet rs = select.executeQuery();
			while(rs.next()) {
				TransactionBean transaction = new TransactionBean();
				transaction.setTransactionId(rs.getString(1));
				transaction.setHomeAccountNumber(rs.getLong(2));
				transaction.setBeneficieryAccountNumber(rs.getLong(3));
				transaction.setAmount(rs.getDouble(4));
				transaction.setTime(rs.getTimestamp(5));
				transactions.add(transaction);
			}
		}catch(Exception e) {e.printStackTrace();}
		return transactions;
	}
}
