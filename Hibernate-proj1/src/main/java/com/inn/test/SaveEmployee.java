package com.inn.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.inn.domain.EmpDetails;

public class SaveEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter first name...");
//		String fname = sc.next();
//		
//		System.out.println("Enter last name...");
//		String lname = sc.next();
//		
//		System.out.println("Enter mail...");
//		String mail = sc.next();
		
		Configuration cfg = new Configuration();
		
		cfg = cfg.configure("/com/inn/cfgs/hibernate-cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session ses = factory.openSession();	
		
		Transaction tx = ses.beginTransaction();
		
		EmpDetails emp = new EmpDetails();
		
		emp.setFname("sonu");
		emp.setLname("soni");
//		emp.setMail("sonu.soni@gmail.com");
		
		try {
			int idVal = (Integer) ses.save(emp);
			System.out.println("id value = "+idVal);
			tx.commit();
			System.out.println("object saved...");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
//		sc.close();
		ses.close();
		factory.close();
	}

}
