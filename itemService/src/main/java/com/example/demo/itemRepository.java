package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface itemRepository extends JpaRepository<items,Long>{
	
	List<items> findAll();
	items findByName(String name);
    //JPA will provide the other implementation of the method we just need to write this
}
