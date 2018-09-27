package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class items {
	
	@Id
	private long id;
	private String name;
	private String desc;
	private Double price;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	protected items(){
		
	}
	public items(long id, String name, String desc, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	@Override
	public String toString() {
		return "items [id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + "]";
	}
	
	

}
