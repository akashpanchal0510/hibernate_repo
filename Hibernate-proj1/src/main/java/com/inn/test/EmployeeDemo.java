package com.inn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.inn.domain.EmpDetails;

public class EmployeeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		
		cfg = cfg.configure("/com/inn/cfgs/hibernate-cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session ses = factory.openSession();	
		
		Transaction tx = ses.beginTransaction();
		
		EmpDetails emp = new EmpDetails();
		
		emp.setFname("akash");
		emp.setLname("panchal");
		emp.setMail("akash.panchal@innoeye.com");
		
		try {
			int idVal = (Integer) ses.save(emp);
			tx.commit();
			System.out.println("object saved...");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
