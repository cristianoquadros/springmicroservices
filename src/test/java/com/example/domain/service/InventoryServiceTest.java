package com.example.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.domain.service.InventoryService;
import com.example.integration.repository.InventoryRepository;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

public class InventoryServiceTest {
	
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
