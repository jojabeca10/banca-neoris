package com.api.bancaneoris.service;

import org.springframework.http.ResponseEntity;
import com.api.bancaneoris.entity.Movimiento;


public interface IMovimientoService {
	ResponseEntity<String> movimiento(Movimiento movimiento);
	ResponseEntity<Object> getMovimiento(String cliente, String data);
}
