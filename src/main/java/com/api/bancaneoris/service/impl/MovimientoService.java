package com.api.bancaneoris.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.bancaneoris.entity.Cuenta;
import com.api.bancaneoris.entity.Movimiento;
import com.api.bancaneoris.entity.Response;
import com.api.bancaneoris.repository.ICuentaRepository;
import com.api.bancaneoris.repository.IMovimientoRepository;
import com.api.bancaneoris.service.IMovimientoService;
import com.api.bancaneoris.util.Util;
import com.google.gson.Gson;

@Service
public class MovimientoService implements IMovimientoService {

	@Autowired
    private IMovimientoRepository iMovimientoRepository;
	@Autowired
    private ICuentaRepository iCuentaRepository;

	@Override
	public ResponseEntity<String> movimiento(Movimiento movimiento) {
		if(Optional.ofNullable(movimiento).isPresent() && 
				Optional.ofNullable(movimiento.getNumCuenta()).isPresent()) {
			Cuenta cuenta = iCuentaRepository.getCuenta(movimiento.getNumCuenta());
			
			if(!Optional.ofNullable(cuenta).isPresent())
				return Util.buildResponse("Cuenta Not found.", HttpStatus.BAD_REQUEST);
			
			Movimiento movAnterior = iMovimientoRepository.getMovimientoAnterior(cuenta.getNumero());
			Double saldo = 0.0;
			if(!Optional.ofNullable(movAnterior).isPresent())
				saldo = cuenta.getSaldoInicial();
			else
				saldo = movAnterior.getSaldo();
			
			String valida = Util.verificaSaldo(saldo, movimiento.getValor());
			if(valida.contains("RETIRO") || valida.contains("DEPOSITO")) {
					movimiento.setFecha(new Date());
					movimiento.setTipo(cuenta.getTipo());
					movimiento.setSaldo(Util.getSaldo());
					movimiento.setMovimiento(valida);
					iMovimientoRepository.save(movimiento);
					return Util.buildResponse(valida, HttpStatus.OK);
			}
			else {
				return Util.buildResponse(valida, HttpStatus.BAD_REQUEST);
			}
			
		}
		return null;
	}

	@Override
	public ResponseEntity<Object> getMovimiento(String cliente, String data) {
		if(Optional.ofNullable(cliente).isPresent()) {
			List<Object> lista = iMovimientoRepository.getMovimiento(cliente);
			if(!lista.isEmpty()) {
				return new ResponseEntity<Object>(new Gson().toJson(lista), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>("Record not found.", HttpStatus.OK);
			}
		}
		return null;
	}
}
