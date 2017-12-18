package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			Student theStudent1 = new Student("Dinesh" ,"Gupta", "dinesh@gmail.com");
			Student theStudent2 = new Student("Anmol" ,"Gupta", "anmol@gmail.com");
			Student theStudent3 = new Student("Anju" ,"Gupta", "anju@gmail.com");
			session.beginTransaction();
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}

	}


