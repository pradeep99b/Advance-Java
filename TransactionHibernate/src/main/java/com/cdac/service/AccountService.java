package com.cdac.service;

import java.time.LocalDateTime;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Account;
import com.cdac.entity.Transaction;
import com.cdac.enums.Status;
import com.cdac.exception.AccountException;

public class AccountService {

	public Transaction transactionPunching(Account account, double amount, String type) {

		Transaction tx = new Transaction();
		tx.setAccount(account);
		tx.setAmount(amount);
		tx.setDateTime(LocalDateTime.now());
		tx.setType(type);
		return tx;

	}

	public void openAccount(Account account) {

		if (account.getBalance() >= 10000) {
			GenericDao gd = new GenericDao();
			account.setStatus(Status.ACTIVE);
			gd.save(account);
		} else
			throw new AccountException("Minimum 10000 required to open an account");

	}

	public void closeAccount(int acno) {
		GenericDao gd = new GenericDao();
		Account account = (Account) gd.fetchById(Account.class, acno);

		if (account.getBalance() >= 0) {
			account.setStatus(Status.CLOSED);
			gd.save(account);
		} else
			throw new AccountException("Please Clear the dues ");
	}

	public void withdraw(int acno, double amount) {

		GenericDao gd = new GenericDao();
		Account account = (Account) gd.fetchById(Account.class, acno);
		double currentBalance = account.getBalance();
		if (account.getStatus() == Status.ACTIVE) {
			if (amount <= currentBalance) {
				account.setBalance(currentBalance - amount);
				gd.save(account);
				Transaction tx = transactionPunching(account, amount, "Withdraw");
				gd.save(tx);
			} else {
				throw new AccountException("Transaction cannot be completed: Insuffcient Balance");
			}
		} else {
			throw new AccountException("PLEASE ACTIVE YOUR ACCOUNT FIRST");
		}

	}

	public void deposit(int acno, double amount) {

		GenericDao gd = new GenericDao();
		Account account = (Account) gd.fetchById(Account.class, acno);
		if (account.getStatus() == Status.ACTIVE) {
			account.setBalance(amount + account.getBalance());
			gd.save(account);
			Transaction tx = new Transaction();
			tx = this.transactionPunching(account, amount, "Deposit");
			gd.save(tx);
		} else {
			throw new AccountException("Cannot deposit, Account is INACTIVE");
		}
	}

	public void transfer(int fromAccno, int toAccno, double amount) {
		
		GenericDao gd = new GenericDao();

		Account fromAccount = (Account) gd.fetchById(Account.class, fromAccno);
		Account toAccount = (Account) gd.fetchById(Account.class, toAccno);
		
		if (fromAccount.getStatus() == Status.ACTIVE && toAccount.getStatus() == Status.ACTIVE) {
			double fromCurrentBalance = fromAccount.getBalance();
			if (amount <= fromCurrentBalance) {
				// Withdraw from the source account
				fromAccount.setBalance(fromCurrentBalance - amount);
				gd.save(fromAccount);
				Transaction withdrawTx = transactionPunching(fromAccount, amount, "Transfer");
				gd.save(withdrawTx);

				// Deposit to the destination account
				toAccount.setBalance(toAccount.getBalance() + amount);
				gd.save(toAccount);
				Transaction depositTx = transactionPunching(toAccount, amount, "Transfer");
				gd.save(depositTx);
			} else {
				throw new AccountException("Transaction cannot be completed: Insufficient Balance in source account");
			}
		} else {
			throw new AccountException("Both accounts must be ACTIVE to complete the transfer");
		}

	}

//	public double balance(int acno) {
//		return balance;
//		
//	}
//	
//	public List<Transaction> miniStatement(int acno) {
//		
//	}

}
