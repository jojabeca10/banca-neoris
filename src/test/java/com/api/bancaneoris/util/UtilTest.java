package com.api.bancaneoris.util;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class UtilTest {

	Util util;
	
	@BeforeEach
    void setUp() {
		
	}
	
	@AfterEach
    void tearDown() {
		util = null;
	}
	
	
	@Test
    void verificaSaldoExcede() {
		assertEquals(util.verificaSaldo(Double.parseDouble("2000"), Double.parseDouble("-2500")), "Valor excede saldo.");
    }
	
	@Test
    void verificaSaldoDeposito() {
		assertEquals(util.verificaSaldo(Double.parseDouble("2000"), Double.parseDouble("2500")), "DEPOSITO de: " + 2500.0);
    }
	
	@Test
    void verificaSaldoSinSaldo() {
		assertEquals(util.verificaSaldo(Double.parseDouble("0"), Double.parseDouble("-500")), "Saldo no disponible.");
    }
	
	@Test
    void buildResponse() {
		assertEquals(util.buildResponse("ok", HttpStatus.OK), new ResponseEntity<String>("ok", HttpStatus.OK));
	}
	
}
