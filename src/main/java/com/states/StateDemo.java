package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ravi.Certificate;
import com.ravi.Student;

public class StateDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Practical of Hibernate Object States
		System.out.println("Example: ");
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Student stud = new Student();
		//student: Transient
		stud.setId(1);
		stud.setName("Abc");
		stud.setCity("Delhi");
		stud.setCerti(new Certificate("UPSC ","1 Year"));
		
		Session s = f.openSession();
		//student: Persistent -session,database
		Transaction tx = s.beginTransaction();
		s.save(stud);
		
		tx.commit();
		
		s.close();
		stud.setName("def");
		
		f.close();
		
	}
	
}
