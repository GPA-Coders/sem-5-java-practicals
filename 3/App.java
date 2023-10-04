package com.pratham.hibernate;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.query.Query;

public class App {
	public static void main(String args[]) {
		try {		
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Transaction t = ss.beginTransaction();
			
			Query q = ss.createQuery("From Student");
			List<Student> students = q.list();		
			
			for (Student s : students) {
				System.out.println(s);
			}
			
			t.commit();
			ss.close();
			sf.close();
		} catch(Exception e) {
			System.out.println("Exception : " + e.toString());
		}
	}
}
