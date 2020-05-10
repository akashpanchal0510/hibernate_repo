package com.inn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inn.domain.Student;

public class LoadStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();

//		cfg = cfg.configure("/com/inn/cfgs/Ora_hibernate-cfg.xml");
		cfg = cfg.configure("/com/inn/cfgs/mysql_hibernate-cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session ses = factory.openSession();

		Student emp = ses.load(Student.class, 1);// if record not found then exception will come

		if (emp != null) {
			System.out.println("SNo :" + emp.getSno() + "\nFirst Name :" + emp.getFname() + "\nLast Name :"
					+ emp.getLname() + "\nMail :" + emp.getMail());

		} else {
			System.out.println("Record not found...");
		}

		ses.close();
		factory.close();
	}

}
