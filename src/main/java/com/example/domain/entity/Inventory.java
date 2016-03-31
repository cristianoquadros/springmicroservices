package com.example.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.config.layers.BaseEntity;

@Entity
public class Inventory implements BaseEntity {
	private static final long serialVersionUID = -489257559184223319L;
	
	public Long id;
	public String description;	
	public Integer amount;
	
	public Inventory() {
		super();
	}
	
	public Inventory(Long id, String description, Integer amount) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
	}
	
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}	