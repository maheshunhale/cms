package com.mahesh.cms.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mahesh.cms.dao.CustomerDAO;
import com.mahesh.cms.exception.CustomerNotFoundException;
import com.mahesh.cms.model.Customer;

@Component
public class CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	private int customerIdCount = 1;
	private List<Customer> customerList = new CopyOnWriteArrayList<>();
	
	public Customer addCustomer(Customer customer) {
		/*customer.setCustomerId(customerIdCount);
		customerList.add(customer);
		customerIdCount++;*/
		return customerDAO.save(customer);
		//return customer;
	}
	
	public List<Customer> getCustomers(){
		return customerDAO.findAll();
		//return customerList;
	}
	
	public Customer getCustomer(int customerId) {
//		return customerList.stream().filter(c -> c.getCustomerId() == customerId).findFirst().get();
//		return customerDAO.findById(customerId).get();
		
		Optional<Customer> optionalCustomer  = customerDAO.findById(customerId);
			if(!optionalCustomer.isPresent())
				throw new CustomerNotFoundException("Customer Record is not available");
		
		return optionalCustomer.get();
	}
	
	public Customer updateCustomer(int customerId,Customer customer) {
		/*customerList.forEach(c->{
			if(c.getCustomerId() == customerId) {
				c.setCustomerFirstName(customer.getCustomerFirstName());
				c.setCustomerLastName(customer.getCustomerLastName());
				c.setCustomerEmail(customer.getCustomerEmail());				
			}
		});
		
		return getCustomer(customerId);*/
		customer.setCustomerId(customerId);
		return customerDAO.save(customer);
	}
	
	public void deleteCustomer(int customerId) {
		
		/*customerList.forEach(c -> {
			if(c.getCustomerId() == customerId)
				customerList.remove(c);
		});*/
		
		customerDAO.deleteById(customerId);
				
		
	}

	public void deleteCustomers() {
		//customerList.clear();
		customerDAO.deleteAll();
		
	}
}
















