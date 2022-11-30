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
import com.api.bancaneoris.entity.Cuenta;
import com.api.bancaneoris.repository.ICuentaRepository;
import com.api.bancaneoris.repository.IPersonaRepository;

class CuentaServiceTest {
	
	ICuentaRepository iCuenta;
	IPersonaRepository ipersona;
	CuentaService cuentaService;
	Cuenta cuenta;
	Cliente cliente;
	
	@BeforeEach
    void setUp() {
		cuentaService = new CuentaService();
		iCuenta = Mockito.mock(ICuentaRepository.class);
		ipersona = Mockito.mock(IPersonaRepository.class);
		ReflectionTestUtils.setField(cuentaService, "iCuentaRepository", iCuenta);
		ReflectionTestUtils.setField(cuentaService, "iPersonaRepository", ipersona);
	}
	
	@AfterEach
    void tearDown() {
		cuentaService = null;
		cliente = null;
		cuenta = null;
		iCuenta = null;
		ipersona = null;
	}

	@Test
    void putCuentaNull() {
		cuentaService = new CuentaService();
		assertNull(cuentaService.putCuenta(cuenta));
    }
	
	public void buildCuenta() {
		cuenta = new Cuenta();
		cuenta.setNumero("1234567");
		cuenta.setIdentiCli(Long.parseLong("987654321"));
	}
	
	@Test
    void putCuentaCliNotFound() {
		buildCuenta();
		when(iCuenta.getCuenta(new String())).thenReturn(cuenta);
		assertEquals(cuentaService.putCuenta(cuenta), new ResponseEntity<String>("Cliente Not found.", HttpStatus.BAD_REQUEST));
    }
}
