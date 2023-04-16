package com.bankapp.model;

import java.io.Serializable;
import java.util.Date;

public class Transactions implements Serializable{
	
	private double deposit;
	private double withdrawal;
	private Date date;
	private Account account;
	private double finalBalance; 


	public Transactions() {}

	public Transactions(double deposit, Date date, Account account, double finalBalance) {
		super();
		this.withdrawal = 0;
		this.deposit = deposit;
		this.date = date;
		this.account = account;
		this.finalBalance = finalBalance;
	}
	
	public double getDeposit() {
		return deposit;
	}
	
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	
	public double getWithdrawal() {
		return withdrawal;
	}
	
	public void setWithdrawal(double withdrawal) {
		this.withdrawal = withdrawal;
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
