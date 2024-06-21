package com.cdac.dao;

import org.hibernate.query.Query;

import com.cdac.entity.Person;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class PersonDao {

	public void add(Person somePerson) {

		EntityManagerFactory emf = null;

		try {
			emf = Persistence.createEntityManagerFactory("passportService");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(somePerson);
			em.getTransaction().commit();

		} finally {

			emf.close();
		}

	}

	public Person fetch(int passport_id) {

		EntityManagerFactory emf = null;
		Person somePerson = null;
		try {
			emf = Persistence.createEntityManagerFactory("passportService");
			EntityManager em = emf.createEntityManager();
			em = emf.createEntityManager();
			Query q = (Query) em.createQuery("select p from Person p inner join PassportInfo pi where pi.passportId=?1");
			q.setParameter(1, passport_id);
			somePerson = (Person) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			emf.close();

		}
		return somePerson;

	}

}
