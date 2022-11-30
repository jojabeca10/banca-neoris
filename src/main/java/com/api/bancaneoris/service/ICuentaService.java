package com.api.bancaneoris.service;

import org.springframework.http.ResponseEntity;
import com.api.bancaneoris.entity.Cuenta;


public interface ICuentaService {
	ResponseEntity<String> putCuenta(Cuenta cuenta);
	ResponseEntity<String> deleteCuenta(Cuenta cuenta);
}
