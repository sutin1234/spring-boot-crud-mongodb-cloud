package com.thinny.spring.mongo.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinny.spring.mongo.api.model.Customer;
import com.thinny.spring.mongo.api.repository.CustomerRepository;

@Service
public class CustomerService {

 private CustomerRepository repository;
 
 @Autowired
 public CustomerService(CustomerRepository repository) {
     this.repository = repository;
 }
 
 public List<Customer> retrieveCustomers() {
     return repository.findAll();
 }

 public Optional<Customer> retrieveCustomers(UUID id) {
     return repository.findById(id);
 }

public List<Customer> retrieveCustomersByName(String name) {
    return repository.findByName(name);
}

 public Customer createCustomer(Customer customer) {
     customer.id = UUID.randomUUID();
     return repository.save(customer);
 }

 public Optional<Customer> updateCustomer(UUID id, Customer customer) {
     Optional<Customer> customerOpt = repository.findById(id);
     if(!customerOpt.isPresent()) {
         return customerOpt;
     }
     customer.setId(id);
     return Optional.of(repository.save(customer));
 }

 public boolean deleteCustomer(UUID id) {
     try {
         repository.deleteById(id);
         return true;
     }
     catch (Exception e) {
         return false;
     }
 }
 
}
