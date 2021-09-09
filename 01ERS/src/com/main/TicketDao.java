package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class TicketDao {


    public void saveTicket(Ticket ticket) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateTicket(Ticket ticket) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteTicket(int rid) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Ticket ticket = session.get(Ticket.class, rid);
            if (ticket != null) {
                session.delete(ticket);
                System.out.println("ticket cancelled");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Ticket getTicket(int rid) {

        Transaction transaction = null;
        Ticket ticket = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ticket = session.get(Ticket.class, rid);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return ticket;
    }

    @SuppressWarnings("unchecked")
    public List < Ticket > getAllTicket(String username) {

        Transaction transaction = null;
        List < Ticket > listOfTicket = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            

            listOfTicket = session.createQuery("from Ticket T where T.user = :username").setParameter("username", username).getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfTicket;
    }
    
    @SuppressWarnings("unchecked")
    public List < Ticket > getPendingTicket() {

        Transaction transaction = null;
        List < Ticket > listOfTicket2 = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            

            listOfTicket2 = session.createQuery("from Ticket T where T.status = 'pending'").getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfTicket2;
    }
}