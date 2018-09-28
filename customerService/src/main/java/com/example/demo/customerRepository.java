package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<customers,Long>{
	
	List<customers> findAll();
	//customers saveCustomer(customers customer);
		
    //JPA will provide the other implementation of the method we just need to write this
}
