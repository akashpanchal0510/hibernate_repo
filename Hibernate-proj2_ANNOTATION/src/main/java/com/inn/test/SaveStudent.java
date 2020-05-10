package com.inn.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.inn.domain.Student;

public class SaveStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first name...");
		String fname = sc.next();
		
		System.out.println("Enter last name...");
		String lname = sc.next();
		
		System.out.println("Enter mail...");
		String mail = sc.next();
		
		Configuration cfg = new Configuration();
		
		cfg = cfg.configure("/com/inn/cfgs/Ora_hibernate-cfg.xml");
//		cfg = cfg.configure("/com/inn/cfgs/mysql_hibernate-cfg.xml");

		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session ses = factory.openSession();	
		
		Transaction tx = ses.beginTransaction();
		
		Student emp = new Student();
		
//		emp.setSno(1);
		emp.setFname(fname);
		emp.setLname(lname);
		emp.setMail(mail);
		
		try {
			int idVal = (Integer) ses.save(emp);
			System.out.println("id value = "+idVal);
			tx.commit();
			System.out.println("object saved...");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
		ses.close();
		factory.close();
	}

}
