package com.example.domain.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.infrastructure.repository.InventoryRepository;

public class ClienteServiceTest {
	
    @InjectMocks
    private InventoryService inventoryService;

    @Mock
    private InventoryRepository inventoryRepository;	
    
    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }    

	@Test
	public void testIsValidInventory() {
		when(inventoryRepository.count()).thenReturn(10L);
		assertThat(inventoryService.isValidInventory("1"), is(true));		
	}
}
