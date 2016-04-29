package com.example.infrastructure.repository;

import com.example.domain.entity.Cliente;


public interface ClienteRepositoryCustom {
	
	Cliente listClientesComCPF(String numero);
	
}
