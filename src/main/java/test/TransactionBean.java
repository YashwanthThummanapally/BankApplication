package test;
import java.io.*;
@SuppressWarnings("serial")
public class TransactionBean implements Serializable {
	private String transactionId;
	private long homeAccountNumber, beneficieryAccountNumber;
	private double amount;
	private java.sql.Timestamp time;
	
	public TransactionBean() {}
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public long getHomeAccountNumber() {
		return homeAccountNumber;
	}
	public void setHomeAccountNumber(long homeAccountNumber) {
		this.homeAccountNumber = homeAccountNumber;
	}
	public long getBeneficieryAccountNumber() {
		return beneficieryAccountNumber;
	}
	public void setBeneficieryAccountNumber(long beneficieryAccountNumber) {
		this.beneficieryAccountNumber = beneficieryAccountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public java.sql.Timestamp getTime() {
		return time;
	}
	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}
}