package com.api.bancaneoris.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.bancaneoris.entity.Cliente;
import com.api.bancaneoris.entity.Cuenta;
import com.api.bancaneoris.entity.Movimiento;
import com.api.bancaneoris.entity.Persona;


public interface IBancaNeorisController {
	ResponseEntity<String> putCliente(Cliente cliente);
	ResponseEntity<String> deleteCliente(Cliente cliente);
	ResponseEntity<String> putCuenta(Cuenta cuenta);
	ResponseEntity<String> deleteCuenta(Cuenta cuenta);
	ResponseEntity<String> movimiento(Movimiento movimiento);
	ResponseEntity<Object> getMovimiento(String cliente, String data);
}
