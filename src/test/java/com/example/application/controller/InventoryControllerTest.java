//package com.example.application.controller;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.boot.test.TestRestTemplate;
//import org.springframework.boot.test.WebIntegrationTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.DemoApplication;
//import com.example.domain.entity.Inventory;
//import com.example.infrastructure.repository.InventoryRepository;
//
//@SpringApplicationConfiguration(classes = DemoApplication.class)
//@WebIntegrationTest({ "server.port=0", "management.port=0" })
//@RunWith(SpringJUnit4ClassRunner.class)
//public class InventoryControllerTest {
//
//	@Autowired
//	private InventoryRepository repository;
//
//	RestTemplate restTemplate = new TestRestTemplate();
//
//	Inventory product1;
//	Inventory product2;
//	Inventory product3;
//
//	@Value("${local.server.port}")
//	int port;
//
//	@Before
//	public void setUp() {
//		product1 = new Inventory(1L, "Produto1", 1);
//		product2 = new Inventory(2L, "Produto2", 2);
//		product3 = new Inventory(3L, "Produto3", 3);
//
//		repository.deleteAll();
//		// repository.save(Arrays.asList(product1, product2, product3));
//	}
//
//	@Test
//	public void testFind() {
//		String url = "http://localhost:" + port + "/demo/inventory";
//		Long invId = product1.getId();
//		
//		restTemplate.postForEntity(url, product1, Inventory.class);
//
//		ResponseEntity<Iterable> responseEntity = restTemplate.getForEntity(url, Iterable.class);
//		 Iterable<Inventory> inventory = ( Iterable<Inventory>) responseEntity.getBody();		
//
//		Assert.assertTrue(inventory != null && inventory.iterator().next().equals(invId));
//
//	}
//}
