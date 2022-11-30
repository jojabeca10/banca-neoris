package com.api.bancaneoris.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Response {
	private Date fecha;
	private String cliente;
	private String numero;
	private String tipo;
	private Double saldoInicial;
    private boolean estado;
    private Double saldo;
    
    
}
