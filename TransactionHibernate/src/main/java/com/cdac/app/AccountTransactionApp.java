package com.cdac.app;

import com.cdac.entity.Account;
import com.cdac.service.AccountService;

public class AccountTransactionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountService accServ = new AccountService();
		
//		Account acc = new Account();
//		acc.setName("NARESH");
//		acc.setBalance(15000);
//		acc.setType("Cuurent");
		
		
		accServ.transfer(2,3,10000d);

	}

}
