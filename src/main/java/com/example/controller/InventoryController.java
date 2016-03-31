package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.entity.Inventory;
import com.example.integration.repository.InventoryRepository;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	public InventoryRepository inventaryRepository;
	
	@Autowired
	public InventoryController(InventoryRepository inventaryRepository) {
		this.inventaryRepository = inventaryRepository;
	}
	
	/**
	 * Retorna uma lista de inventários sem nenhum filtro para consulta.
	 * <p>
	 * Caso não existe nenhum registro o sistema retornará uma lista
	 * vazia.
	 * 
	 * GET method
	 * No context
	 * Header: json/application
	 * 
	 * @return      Lista de inventários
	 * @see         Inventory
	 * 
	 */	
	@RequestMapping(method=RequestMethod.GET) 
	public Iterable<Inventory> searchAll(){
		return inventaryRepository.findAll();
	}
	
	/**
	 * Persiste um item de inventário na base de dados.
	 * <p>
	 * O sistema validará campos obrigatórios antes da
	 * persistência
	 * 
	 * POST method
	 * No context
	 * Header: json/application
	 * 
	 * @param  entity, 
	 * 
	 * @see         Inventory
	 */		
	@RequestMapping(method=RequestMethod.POST)
	public void save(@RequestBody Inventory entity){
		inventaryRepository.save(entity);
	}	
	

}
