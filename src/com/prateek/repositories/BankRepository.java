package com.prateek.repositories;



import org.hibernate.cfg.Configuration;

import com.prateek.entities.Account;
import com.prateek.entities.Bank;
import com.prateek.entities.Patron;
import com.prateek.entities.Result;

import java.util.Iterator;
import java.util.List;
import java.util.Locale.Category;
import java.util.Scanner;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BankRepository {

	private SessionFactory sessionFactory;


public BankRepository() {
		
	 try {
   	  sessionFactory =
   			    new Configuration().configure("hibernate.cfg.xml")
   			    .addAnnotatedClass(Patron.class)
   			    .addAnnotatedClass(Account.class)
   			    .addAnnotatedClass(Bank.class)
   			    .addAnnotatedClass(Transaction.class)
   			    .buildSessionFactory();
   	  
   	  } 
	 catch (Exception e) { 
        System.err.println(e.getMessage());
     }
	 
	}


		public Result add(Patron p){
			 
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		Integer patronID = null;

		try {
			tx = session.beginTransaction();

			patronID = (Integer) session.save(p);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return Result.SUCCESS;
	      
	      
	   }
		
		
		public Result remove(Patron p2) {
			// TODO Auto-generated method stub
			
			Session session = sessionFactory.getCurrentSession();
		      Transaction tx = null;
		      
		      try {
		         tx = session.beginTransaction();
		         Patron patron = (Patron)session.get(Patron.class, p2.getId()); 
		         session.delete(patron); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
			return Result.SUCCESS;
		   }
			
		
		
		public Result update(Patron p3) 
		{
			Session session = sessionFactory.openSession();
		      Transaction tx = null;
		      Scanner sc1 = null;
		      try {
		         tx = session.beginTransaction();
		         Patron patron = (Patron)session.get(Patron.class, p3.getId()); 
		         System.out.println("Enter the new name to update -");
		         String name = sc1.nextLine();
		         patron.setName(name);
				 session.update(patron); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
			return Result.SUCCESS;
		}


		public Patron findPatron(int id3) {
			
			Session session = sessionFactory.openSession();
		      Transaction tx = null;
		      Patron patron = null;
		      try {
		            
		            patron =  session.get(Patron.class,id3);
		            Hibernate.initialize(patron);
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            if (session != null && session.isOpen()) {
		                session.close();
		            }
		        }
			System.out.println(patron.getName());
			
			return patron;
			
			
		}


		public List<Patron> findPatron(String name) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
		      Transaction tx = null;
		      List<Patron> patron = null;
		      session.beginTransaction();
		      patron = session.createQuery("from Patron p where p.name=?1").setParameter(1, name).getResultList();
			
		      for(Patron patronlist:patron) 
		      {
		    	  System.out.println(patronlist);
		      }
		      session.getTransaction().commit();
		     
			return patron;
		}

		
		
		
		public Transaction findTransaction(int id) 
		{
			Session session = sessionFactory.openSession();
		      Transaction tx = null;
			session.beginTransaction();
			Transaction transById = session.get(Transaction.class,id);
			System.out.println(transById);
			session.getTransaction().commit();
			
			return transById;
		}

		public Result add(Bank bb) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = null;
			Integer bankid;
			try {
				tx = session.beginTransaction();

				bankid = (Integer) session.save(bb);
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			return Result.SUCCESS;

		}
		
		public Result remove(Bank bank) 
		{
			Session session = sessionFactory.getCurrentSession();
		      Transaction tx = null;
		      
		      try {
		         tx = session.beginTransaction();
		         Bank bank1 = (Bank)session.get(Bank.class, bank.getId()); 
		         session.delete(bank1); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
			return Result.SUCCESS;
		}

		
		public Result update(Bank bb2) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
		      Transaction tx = null;
		      Scanner sc1 = null;
		      try {
		         tx = session.beginTransaction();
		         Bank bank = (Bank)session.get(Bank.class, bb2.getId()); 
		         System.out.println("Enter the new name to update -");
		         String name = sc1.nextLine();
		         bank.setId(bb2.getId());
		         bank.setName(bb2.getName());
				 session.update(bank); 
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
			return Result.SUCCESS;
		}


		public Bank findBank(Bank bb3) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
		      Transaction tx = null;
			session.beginTransaction();
			Bank bankbyid = session.get(Bank.class, bb3.getId());
			System.out.println(bankbyid);
			session.getTransaction().commit();
			
			return bankbyid;
		}

		public List<Bank> findBank(String name)
		{
			Session session = sessionFactory.openSession();
		      Transaction tx = null;
		      List<Bank> bank = null;
		      session.beginTransaction();
		      bank = session.createQuery("from bank p where p.name=?1").setParameter(1, name).getResultList();
			
		      for(Bank banklist:bank) 
		      {
		    	  System.out.println(banklist);
		      }
		      session.getTransaction().commit();
		      
			return bank;
		}

		public Result add(Account a) 
		{
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = null;
			Integer accountid;
			try {
				tx = session.beginTransaction();

				accountid = (Integer) session.save(a);
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			return Result.SUCCESS;
		}
		
	/*	
		public Result delete(Account a) 
		{
			
		}

		
		public Account findAccount(int id) 
		{
			
		}

		public Result transact(Transaction t) 
		{
	      
			
		}
		
		
		public Result update(Account a) {
			// TODO Auto-generated method stub
			
		}
*/
		
	   
	
	   
}
