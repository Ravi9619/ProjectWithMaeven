package com.ravi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started...");
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        
        //creating student
        Student st = new Student();
        st.setId(107);
        st.setName("abc");
        st.setCity("Mum");
        
        //creating object of address class
        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("mumbai");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(121);
        
        //Reading Image
        FileInputStream fs = new FileInputStream("src/main/java/india.jfif");
        byte[] data;
		try {
			data = new byte[fs.available()];
			fs.read(data);
	        ad.setImage(data);
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        Session session =  factory.openSession();
        
        Transaction tx = session.beginTransaction(); 
        session.save(st);
        session.save(ad); 
        tx.commit();  
        session.close();
        System.out.println("Done");
    }
}
