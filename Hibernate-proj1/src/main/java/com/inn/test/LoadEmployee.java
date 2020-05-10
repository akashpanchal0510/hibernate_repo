package com.inn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inn.domain.EmpDetails;

public class LoadEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();

		cfg = cfg.configure("/com/inn/cfgs/hibernate-cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session ses = factory.openSession();

		EmpDetails emp = ses.load(EmpDetails.class, 1);// if record not found then exception will come

		if (emp != null) {
			System.out.println("Emp No :" + emp.getNo() + "\nFirst Name :" + emp.getFname() + "\nLast Name :"
					+ emp.getLname() + "\nMail :" + emp.getMail());

		} else {
			System.out.println("Record not found...");
		}

		ses.close();
		factory.close();
	}

}
