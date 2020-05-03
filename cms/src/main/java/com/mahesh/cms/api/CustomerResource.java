package com.mahesh.cms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.cms.model.Customer;
import com.mahesh.cms.service.CustomerService;
@RestController
@RequestMapping(value="/customers")
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping(value="/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int customerId) {
		return customerService.getCustomer(customerId);
	}
	
	@PutMapping(value = "/{customerId}")
	public Customer updateCustomer(@PathVariable("customerId") int customerId,@RequestBody Customer customer){
		return customerService.updateCustomer(customerId, customer);
	}
	
	@DeleteMapping(value="/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") int customerId) {
		customerService.deleteCustomer(customerId);
	}	
	
	@DeleteMapping
	public void deleteCustomers() {
		customerService.deleteCustomers();
	}
}
