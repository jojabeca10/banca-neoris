package com.api.bancaneoris.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {
	
	private static final String RETIRO = "RETIRO de: ";
	private static final String DEPOSITO = "DEPOSITO de: ";
	private static Double saldo;

	public static ResponseEntity<String> buildResponse(String data, HttpStatus status) {
		return new ResponseEntity<String>(data, status);
	}
	
	public static String verificaSaldo(Double saldoActual, Double valor) {
		saldo = saldoActual;
		if(valor > 0) {
			saldo += valor;
			return DEPOSITO + valor;
		}
		else {
			if(saldoActual < 1)
				return "Saldo no disponible.";
			else if((valor * -1) > saldoActual)
				return "Valor excede saldo.";
			else {
				saldo += valor;
				return RETIRO + valor;
			}
		}	
	}
	
	public static Double getSaldo() {
		return saldo;
	}
}
