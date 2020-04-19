package com.thinny.spring.mongo.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.thinny.spring.mongo.api.model.*;
import com.thinny.spring.mongo.api.service.CustomerService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
	@Autowired
    private CustomerService customerService;
	
	@GetMapping()
    public ResponseEntity<?> getCustomers() {
        List<Customer> customers = customerService.retrieveCustomers();
        return ResponseEntity.ok(customers);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable UUID id) {
        Optional<?> customer = customerService.retrieveCustomers(id);
        if(!customer.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping(params = "name")
    public ResponseEntity<?> getCustomers(@RequestParam String name) {
        List<Customer> customers = customerService.retrieveCustomersByName(name);
        return ResponseEntity.ok(customers);
    }

    
	
	@PostMapping()
    public ResponseEntity<?> postCustomers(@RequestBody Customer body) {
        Customer customer = customerService.createCustomer(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<?> putCustomers(@PathVariable UUID id, @RequestBody Customer body) {
        Optional<?> customer = customerService.updateCustomer(id, body);
        return ResponseEntity.ok(customer);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomers(@PathVariable UUID id) {
        if(!customerService.deleteCustomer(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
