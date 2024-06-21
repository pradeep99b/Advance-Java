package com.cdac.app;

import com.cdac.dao.PersonDao;
import com.cdac.entity.PassportInfo;
import com.cdac.entity.Person;

public class FindPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		PersonDao dao = new PersonDao();
		Person somePerson = dao.fetch(1);
		
		System.out.println(somePerson.getEmail());
		System.out.println(somePerson.getMobileNumber());
		System.out.println(somePerson.getName());
		System.out.println(somePerson.getPersonId());
		PassportInfo info = somePerson.getPassportInfo();
		System.out.println(info.getIssuedBy());
		System.out.println(info.getExpDate());
		System.out.println(info.getIssueDate());
		
	}

}
