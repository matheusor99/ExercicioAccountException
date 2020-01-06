package model.entities;

import javax.security.auth.login.AccountException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance, withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	public void withdraw(Double amount) throws AccountException {
		if (balance < amount) {
			throw new AccountException("Not enough balance");
		} else if (amount > withdrawLimit) {
			throw new AccountException("The amount exceeds withdraw limit");
		} else {
			balance -= amount;
		}
		
	}
}
