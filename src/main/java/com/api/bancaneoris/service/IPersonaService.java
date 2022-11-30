package com.api.bancaneoris.service;

import org.springframework.http.ResponseEntity;

import com.api.bancaneoris.entity.Cliente;


public interface IPersonaService {
	ResponseEntity<String> putCliente(Cliente cliente);
	ResponseEntity<String> deleteCliente(Cliente cliente);
}
