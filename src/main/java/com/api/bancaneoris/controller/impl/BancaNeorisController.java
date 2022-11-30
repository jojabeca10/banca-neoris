package com.api.bancaneoris.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.bancaneoris.controller.IBancaNeorisController;
import com.api.bancaneoris.entity.Cliente;
import com.api.bancaneoris.entity.Cuenta;
import com.api.bancaneoris.entity.Movimiento;
import com.api.bancaneoris.entity.Persona;
import com.api.bancaneoris.service.ICuentaService;
import com.api.bancaneoris.service.IMovimientoService;
import com.api.bancaneoris.service.IPersonaService;

@RestController
@RequestMapping("/app")
public class BancaNeorisController implements IBancaNeorisController {
	
	@Autowired
	private IPersonaService iClienteService;
	@Autowired
	private ICuentaService iCuentaService;
	@Autowired
	private IMovimientoService iMovimientoService;

	@Override
	@PutMapping(path = "/clientes", 
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> putCliente(@RequestBody Cliente cliente) {
		return iClienteService.putCliente(cliente);
	}
	
	@Override
	@DeleteMapping(path = "/clientes", 
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCliente(@RequestBody Cliente cliente) {
		return iClienteService.deleteCliente(cliente);
	}

	@Override
	@PutMapping(path = "/cuentas",
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> putCuenta(@RequestBody Cuenta cuenta) {
		return iCuentaService.putCuenta(cuenta);
	}
	
	@Override
	@DeleteMapping(path = "/cuentas",
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCuenta(@RequestBody Cuenta cuenta) {
		return iCuentaService.deleteCuenta(cuenta);
	}

	@Override
	@PostMapping(path = "/movimientos",
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> movimiento(@RequestBody Movimiento movimiento) {
		return iMovimientoService.movimiento(movimiento);
	}
	
	@Override
	@GetMapping(path = "/movimientos/{cliente}",
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getMovimiento(@PathVariable String cliente, @RequestBody (required = false) String data) {
		return iMovimientoService.getMovimiento(cliente, data);
	}

}