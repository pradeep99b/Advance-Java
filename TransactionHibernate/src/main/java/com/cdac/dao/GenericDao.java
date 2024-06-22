package com.cdac.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GenericDao {
	
	private EntityManagerFactory emf;
	
	public GenericDao() {
		emf = Persistence.createEntityManagerFactory("TransactionHibernate");
		
	}
	
	public void close() {
		if(emf != null && emf.isOpen() ) {
			emf.close();
		}
	}
	
	public void save(Object obj) {

		EntityManager em = null; 
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(obj);//merge can be used for insert as well as update
			em.getTransaction().commit();

		} finally {
			if( em != null)
				em.close();
		}

	}

	public Object fetchById(Class clazz, int id) {

		Object obj = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em = emf.createEntityManager();
			
			obj = em.find(clazz, id);
			
		}  finally {
			if(em != null) 
				em.close();		
		}
		return obj;

	}
	
	public void deleteById(Class clazz, int id) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();			
			em.getTransaction().begin();
			Object obj = em.find(clazz,id);
			em.remove(obj);
			em.getTransaction().commit();
		}  finally {
			if( em != null)
				em.close();

		}
		

	}

}
