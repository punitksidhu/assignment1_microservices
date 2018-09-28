package com.example.demo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController

public class customerServiceController {
	
	@Autowired
	customerRepository customerrepository;
	
	@GetMapping("/port/service1/customers")
	public List<customers> getCustomers(){
		customerrepository.findAll();
		List<customers> customers=customerrepository.findAll();
		return customers;
		
	}
	
	
	@PostMapping("/port/service1/customer")
	
	public ResponseEntity<Object> createcustomer(@RequestBody customers customer) {
		customers savedcustomer = customerrepository.save(customer);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedcustomer.getCustomerId()).toUri();

		return ResponseEntity.created(location).build();

	}
		
	}


