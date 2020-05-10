package com.inn.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.inn.domain.EmpDetails;

public class DeleteEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();

//		cfg = cfg.configure("/com/inn/cfgs/Ora_hibernate-cfg.xml");
		cfg = cfg.configure("/com/inn/cfgs/mysql_hibernate-cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session ses = factory.openSession();

		Transaction tx = ses.beginTransaction();

		EmpDetails emp = ses.get(EmpDetails.class, 10);
//		EmpDetails emp = ses.load(EmpDetails.class, 10);

		if (emp != null) {
			try {
				ses.delete(emp);
				tx.commit();
				System.out.println("record deleted");
			} catch (Exception e) {
				// TODO: handle exception
				tx.rollback();
				e.printStackTrace();
			}
		} else {
			System.out.println("record not found...");
		}

		ses.close();
		factory.close();
	}

}
