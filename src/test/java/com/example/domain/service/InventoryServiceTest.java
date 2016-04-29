package com.example.domain.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.example.domain.entity.Cliente;

public class InventoryServiceTest {
	
    @InjectMocks
    private ClienteService clienteService;	
    
    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }    

	@Test
	public void testValidaCamposFormulario() {
		Cliente cliente = new Cliente();
		
		assertThat(clienteService.validaCamposFormulario(cliente), is(false));		
		cliente.setNome("Elvis Presley");
		assertThat(clienteService.validaCamposFormulario(cliente), is(false));
		
		cliente.setEndereco("Rua Nova, 3333");
		assertThat(clienteService.validaCamposFormulario(cliente), is(false));		
		
		cliente.setNumeroDocumento("12345678903");
		assertThat(clienteService.validaCamposFormulario(cliente), is(true));			
	}
	
}