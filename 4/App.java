package com.pratham.hibernate;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.query.*;

public class App {
	public static void main(String args[]) {
		try {		
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Transaction t = ss.beginTransaction();
			
			Employee e = new Employee();
			
			Query q = ss.createQuery("select avg(salary) from Employee");
			List<Integer> list = q.list();
			System.out.println("Average salary :" + list.get(0));
			
			Query q1 = ss.createQuery("select min(salary) from Employee");
			List<Integer> list1 = q1.list();
			System.out.println("Minimum salary :" + list1.get(0));
			
			Query q2 = ss.createQuery("select max(salary) from Employee");
			List<Integer> list2 = q2.list();
			System.out.println("Maximum salary :" + list2.get(0));
			
			Query q3 = ss.createQuery("select sum(salary) from Employee");
			List<Integer> list3 = q3.list();
			System.out.println("Total salary :" + list3.get(0));
			
			t.commit();
			ss.close();
			sf.close();
		} catch(Exception e) {
			System.out.println("Exception : " + e.toString());
		}
	}
}
