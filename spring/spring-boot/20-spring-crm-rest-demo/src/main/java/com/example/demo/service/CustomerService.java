package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.util.List;



public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
