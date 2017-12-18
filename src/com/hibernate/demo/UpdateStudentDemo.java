package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			int studentId= 1;
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Update student....");
			myStudent.setFirstName("Scooby");
			
			session.getTransaction().commit();
			
		
			
			System.out.println("Getting done....." +myStudent);
		}
		finally{
			factory.close();
		}
	}

}
