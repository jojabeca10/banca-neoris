package com.api.bancaneoris.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.api.bancaneoris.entity.Cliente;
import com.api.bancaneoris.repository.IPersonaRepository;

class ClienteServiceTest {
	
	ClienteService clienteService;
	Cliente cliente;
	
	@BeforeEach
    void setUp() {
		clienteService = new ClienteService();
	}
	
	@AfterEach
    void tearDown() {
		clienteService = null;
		cliente = null;
	}

	@Test
    void putClienteNull() {
		assertNull(clienteService.putCliente(cliente));
    }
	
	@Test
    void putCliente() {
		cliente = new Cliente();
		cliente.setIdentificacion(Long.parseLong("123"));
		IPersonaRepository ipersona = Mockito.mock(IPersonaRepository.class);
		ReflectionTestUtils.setField(clienteService, "iPersonaRepository", ipersona);
		when(ipersona.getPersona(1L)).thenReturn(cliente);
		assertEquals(clienteService.putCliente(cliente), new ResponseEntity<String>("Put ok", HttpStatus.OK));
    }
	
	@Test
    void putClienteException() {
		assertEquals(clienteService.putCliente(new Cliente()), new ResponseEntity<String>("Error..: null", HttpStatus.BAD_REQUEST));
    }

}
