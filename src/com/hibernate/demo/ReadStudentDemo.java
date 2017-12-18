package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			Student theStudent = new Student("Radhika" ,"Gupta", "radhika@gmail.com");
			session.beginTransaction();
			session.save(theStudent);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with Id: "+theStudent.getId());
			
			Student myStudent = session.get(Student.class, theStudent.getId());
			
			System.out.println("Getting done....." +myStudent);
		}
		finally{
			factory.close();
		}
	}

}
