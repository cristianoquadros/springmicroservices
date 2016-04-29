package com.example.domain.service;

import org.springframework.stereotype.Service;

import com.example.domain.entity.Cliente;

import org.springframework.util.StringUtils;

@Service
public class ClienteService {
	
	public boolean validaCamposFormulario(Cliente cliente){
		boolean valid = true;
		
		if (StringUtils.isEmpty(cliente.getNome())){
			valid = false;
		}else if (StringUtils.isEmpty(cliente.getEndereco())){
			valid = false;
		}else if (StringUtils.isEmpty(cliente.getNumeroDocumento())){
			valid = false;			
		}		
		return valid;
	}
	
}
