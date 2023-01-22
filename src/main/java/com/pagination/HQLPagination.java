package com.pagination;

import org.hibernate.query.*;

import com.ravi.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPagination {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Query query = s.createQuery("from Student");
		
		//implementing pagination
		query.setFirstResult(3);
		
		query.setMaxResults(5);
		
		List<Student> list = query.list();
		
		for(Student st: list)
		{
			System.out.println(st.getId()+" : "+st.getName()+" : "+st.getCity());
			
		}
		
		s.close();
		
		factory.close();

	}

}
