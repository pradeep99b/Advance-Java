package com.cdac.app;

import java.time.LocalDate;

import com.cdac.dao.*;
import com.cdac.entity.PassportInfo;
import com.cdac.entity.Person;

public class PersonApp {

	public static void main(String[] args) {
		
		PersonDao dao = new PersonDao();
		
		Person somePerson = new Person();
		somePerson.setEmail("bahukhandi99p@gmail.com");
		somePerson.setName("Pradeep");
		somePerson.setMobileNumber(7060009866L);
		
		PassportInfo info = new PassportInfo();
		info.setExpDate(LocalDate.of(2028, 5, 24));
		info.setIssueDate(LocalDate.of(2021, 5, 27));
		info.setIssuedBy("Government of India");
		
		somePerson.setPassportInfo(info);
		dao.add(somePerson);

	}

}
