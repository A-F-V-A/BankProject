package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Account implements Serializable{
	private String number;
	private Owner ownre;
	private double balance ;
    private double lastBalance;
	private TypeAccount typeAccount;
	private ArrayList<Transactions> transactions;
	
	public Account() { 
		this.balance = 0;
		this.transactions = new ArrayList<>();
	}


	public ArrayList<Transactions> gettransactions (){
		return transactions;
	}

	public Account(String number, Owner ownre, TypeAccount typeAccount) {
		super();
		this.transactions = new ArrayList<>();
		this.number = number;
		this.ownre = ownre;
		this.balance = 0;
		this.typeAccount = typeAccount;
		this.lastBalance = 0;
	}
	
	public void deposit(double amount) throws IllegalArgumentException {
	    if(amount <= 0){
	        throw new IllegalArgumentException("El monto a depositar debe ser mayor que cero");
	    }
	    lastBalance = amount;
	    balance += amount;
	    Transactions transaction = new Transactions((balance - amount), TypeTransaction.DEPOSITO, new Date(), this, balance, lastBalance);
	    transactions.add(transaction);
	}

	public void withdraw(double amount) throws IllegalArgumentException {
	    if (balance < amount) {
	        throw new IllegalArgumentException("No hay suficiente saldo para retirar esta cantidad");
	    }
	    if(amount <= 10000){
	        throw new IllegalArgumentException("El monto a retirar debe ser mayor que diez");
	    }
	    
	    double lastTransactionBalance = getLastTransactionBalance();
	    
	    
	    lastBalance = balance;
	    balance -= amount;
	    double inicialBalance = (lastTransactionBalance + amount) - balance;
	    
	    Transactions transaction = new Transactions(lastBalance, TypeTransaction.RETIRO, new Date(), this, balance, lastBalance);
	    transactions.add(transaction);
	}
	
	private double getLastTransactionBalance() {
	    int n = transactions.size();
	    if (n > 0) {
	        return transactions.get(n - 1).getInitialBalance();
	    } else {
	        return balance;
	    }
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
