package com.map.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Person person = new Person(12,"Ravi","Mum","32214");
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(person);
		
		tx.commit();
		s.close();
		factory.close();

	}

}
