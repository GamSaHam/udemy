package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;


@Repository
public class CustomerDAOImpl implements CustomerDAO {



	@Autowired
	private EntityManagerFactory entityManagerFactory;



	@Override
	public List<Customer> getCustomers() {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}


		SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
		Session currentSession = sessionFactory.openSession();

		// create a query  ... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",
											Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}


		SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
		// get current hibernate session
		Session currentSession = sessionFactory.openSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}


		SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
		// get the current hibernate session
		Session currentSession = sessionFactory.openSession();
		
		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}


		SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
		// get the current hibernate session
		Session currentSession = sessionFactory.openSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}

}











