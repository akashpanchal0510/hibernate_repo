package com.inn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.inn.domain.EmpDetails;

public class UpdateEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();

		cfg = cfg.configure("/com/inn/cfgs/hibernate-cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session ses = factory.openSession();

		Transaction tx = ses.beginTransaction();

		EmpDetails emp = ses.get(EmpDetails.class, 7);

//		EmpDetails emp = ses.load(EmpDetails.class, 10);

		if (emp != null) {
			emp.setFname("mukesh");
			emp.setLname("sharma");
			emp.setMail("mukesh.sharma@gmail.com");
			try {
				ses.update(emp);
				tx.commit();
				System.out.println("record updated");
			} catch (Exception e) {
				// TODO: handle exception
				tx.rollback();
				e.printStackTrace();
			}
		} else {
			System.out.println("record not found for updation...");
		}

		ses.close();
		factory.close();
	}

}
