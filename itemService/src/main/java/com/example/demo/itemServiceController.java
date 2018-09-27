package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class itemServiceController {
	
	@Autowired
	itemRepository itemrepository;
	@GetMapping("/port/service2/items")
	public List<items> GetAllItems(){
		
		List<items> items=itemrepository.findAll();
		return items;
		
	}
	
	@GetMapping("/port/service2/items/{itemname}")
	public items searchByItemName(@PathVariable String itemname){
		items item=itemrepository.findByName(itemname);
		return item;
		
	}

}
