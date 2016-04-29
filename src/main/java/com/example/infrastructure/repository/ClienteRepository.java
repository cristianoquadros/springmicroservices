package com.example.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
}
