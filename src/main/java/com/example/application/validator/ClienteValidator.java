package com.example.application.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.domain.entity.Cliente;
import com.example.domain.entity.ProductDetail;
import com.example.domain.service.ClienteService;

@Component
public class ClienteValidator implements Validator {
	
    private ClienteService clienteService;
    
    @Autowired
    public ClienteValidator(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        Cliente cliente = (Cliente) target;
 //       if (!inventoryService.isValidInventory(detail.getInventoryId())) {
//            errors.rejectValue("inventoryId", "inventory.id.invalid", "ID de Estoque inválido");
//        }
    }

	@Override
	public boolean supports(Class clazz) {
		return ProductDetail.class.isAssignableFrom(clazz);
	}
}