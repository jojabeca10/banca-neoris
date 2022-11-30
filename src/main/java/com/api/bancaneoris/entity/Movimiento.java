package com.api.bancaneoris.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "movimiento")
@ToString
@Getter
@Setter
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mov_sequence")
	@SequenceGenerator(name="mov_sequence", sequenceName = "mov_sequence", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "fecha", nullable = false)
    private Date fecha;
	
	@Column(name = "tipo", nullable = false)
    private String tipo;
	
	@Column(name = "valor", nullable = false)
    private Double valor;
	
	@Column(name = "saldo", nullable = false)
    private Double saldo;
	
	@Column(name = "movimiento", nullable = false)
    private String movimiento;
	
	@Column(name = "num_cuenta", nullable = false)
	private String numCuenta;
}
