package com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class ManagerDao {


	    public void saveManager(Manager manager) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(manager);
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
	        Manager manager = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            manager = (Manager) 
	            		session.createQuery("FROM Manager M WHERE M.username = :username").setParameter("username", username)
	                .uniqueResult();

	            if (manager != null && manager.getPassword().equals(password)) {
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


