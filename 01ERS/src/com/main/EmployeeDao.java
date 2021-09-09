package com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class EmployeeDao {


	    public void saveEmployee(Employee employee) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(employee);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

	    public boolean validate(String username, String password) {

	        Transaction transaction = null;
	        Employee employee = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            employee = (Employee) 
	            		session.createQuery("FROM Employee E WHERE E.username = :username").setParameter("username", username)
	                .uniqueResult();

	            if (employee != null && employee.getPassword().equals(password)) {
	                return true;
	            }
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return false;
	    }

	}


