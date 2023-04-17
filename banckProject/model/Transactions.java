package model;

import java.io.Serializable;
import java.util.Date;

public class Transactions implements Serializable{
	
	private double deposit;
	private TypeTransactions typeTransactions;
	private Date date;
	private Account account;
	private double finalBalance; 


	public Transactions() {}

	public Transactions(double deposit, Date date, TypeTransactions typeTransactions, double finalBalance) {
		super();
		this.typeTransactions = typeTransactions;
		this.deposit = deposit;
		this.date = date;
		this.finalBalance = finalBalance;
	}
	
	public double getDeposit() {
		return deposit;
	}
	
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public TypeTransactions typeTransactions(){
		return typeTransactions;
	}

	public void typeTransactions(TypeTransactions typeTransactions){
		this.typeTransactions = typeTransactions;
	}
	

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public double getFinalBalance() {
		return finalBalance;
	}

	public void setFinalBalance(double finalBalance) {
		this.finalBalance = finalBalance;
	}
	
}
