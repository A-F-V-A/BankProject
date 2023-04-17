package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable{
	private String number;
	private Owner ownre;
	private double balance ;
	private TypeAccount typeAccount;
	private ArrayList<Transactions> transactions;
	
	public Account() { this.balance = 0;}

	public Account(String number, Owner ownre, TypeAccount typeAccount) {
		super();
		this.transactions = new ArrayList<>();
		this.number = number;
		this.ownre = ownre;
		this.balance = 0;
		this.typeAccount = typeAccount;
	}
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Owner getOwnre() {
		return ownre;
	}
	
	public void setOwnre(Owner ownre) {
		this.ownre = ownre;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public TypeAccount getTypeAccount() {
		return typeAccount;
	}
	
	public void setTypeAccount(TypeAccount typeAccount) {
		this.typeAccount = typeAccount;
	}
	
}
