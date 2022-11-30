package com.api.bancaneoris.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
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
import com.api.bancaneoris.entity.Movimiento;
import com.api.bancaneoris.repository.ICuentaRepository;
import com.api.bancaneoris.repository.IPersonaRepository;

class MovimientoServiceTest {
	
	ICuentaRepository iCuenta;
	MovimientoService movimientoService;
	Movimiento movimiento;
	Cuenta cuenta;
	
	@BeforeEach
    void setUp() {
		iCuenta = Mockito.mock(ICuentaRepository.class);
		movimientoService = new MovimientoService();
		movimiento = new Movimiento();
		ReflectionTestUtils.setField(movimientoService, "iCuentaRepository", iCuenta);
	}
	
	@AfterEach
    void tearDown() {
		movimientoService = null;
		movimiento = null;
		iCuenta = null;
		cuenta = null;
	}
	
	@Test
    void movimientoNull() {
		assertNull(movimientoService.movimiento(movimiento));
    }
	
	public void buildCuenta() {
		cuenta = new Cuenta();
		cuenta.setNumero("1234567");
		cuenta.setIdentiCli(Long.parseLong("987654321"));
	}
	
	@Test
    void movimientoCuentaNotFound() {
		movimiento.setNumCuenta("1234567");
		when(iCuenta.getCuenta(new String())).thenReturn(cuenta);
		assertEquals(movimientoService.movimiento(movimiento), new ResponseEntity<String>("Cuenta Not found.", HttpStatus.BAD_REQUEST));
    }
	
	@Test
    void movimiento() {
		movimientoService = Mockito.mock(MovimientoService.class);
		movimientoService.movimiento(movimiento);
		verify(movimientoService).movimiento(movimiento);
    }
}
