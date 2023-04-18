package model;

import java.io.Serializable;
import java.util.Date;

public class Transactions implements Serializable{
	
	private double initialBalance;
	private TypeTransaction typeTransactions;
	private Date date;
	private Account account;
	private double finalBalance; 
    private double transaction;

	public Transactions() {
		
	}
	
	public Transactions(double initialBalance, TypeTransaction typeTransactions, Date date, Account account,
			double finalBalance, double transaction) {
		super();
		this.initialBalance = initialBalance;
		this.typeTransactions = typeTransactions;
		this.date = date;
		this.account = account;
		this.finalBalance = finalBalance;
		this.transaction = transaction;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public TypeTransaction getTypeTransactions() {
		return typeTransactions;
	}

	public void setTypeTransactions(TypeTransaction typeTransactions) {
		this.typeTransactions = typeTransactions;
	}

	public TypeTransaction typeTransactions(){
		return typeTransactions;
	}

	public void typeTransactions(TypeTransaction typeTransactions){
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

	public double getTransaction() {
		return transaction;
	}

	public void setTransaction(double transaction) {
		this.transaction = transaction;
	}	
}
