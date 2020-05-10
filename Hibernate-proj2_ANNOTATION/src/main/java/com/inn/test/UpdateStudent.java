package com.inn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.inn.domain.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();

//		cfg = cfg.configure("/com/inn/cfgs/Ora_hibernate-cfg.xml");
		cfg = cfg.configure("/com/inn/cfgs/mysql_hibernate-cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session ses = factory.openSession();

		Transaction tx = ses.beginTransaction();

		Student emp = ses.get(Student.class, 7);

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
