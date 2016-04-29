package com.example.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.entity.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
	
	@Query("select i from Inventory i where description like UPPER(?1)")
	List<Inventory> searchByDescription(String description);
	
}
