package com.api.bancaneoris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cuenta")
@ToString
@Getter
@Setter
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuen_sequence")
	@SequenceGenerator(name="cuen_sequence", sequenceName = "cuen_sequence", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "numero", nullable = false)
    private String numero;
	
	@Column(name = "tipo", nullable = false)
    private String tipo;
	
	@Column(name = "saldo_inicial", nullable = false)
    private Double saldoInicial;
	
	@Column(name = "estado", nullable = false)
    private boolean estado;

	@Column(name = "cliente", nullable = false)
    private String cliente;
	
	@Transient
	private Long identiCli;
}
