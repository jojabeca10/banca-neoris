package com.api.bancaneoris.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "persona")
@ToString
@Getter
@Setter
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "per_sequence")
	@SequenceGenerator(name="per_sequence", sequenceName = "per_sequence", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
    private String nombre;
	
	@Column(name = "genero", nullable = false)
    private char genero;
	
	@Column(name = "edad", nullable = false)
    private int edad;
	
	@Column(name = "identificacion", nullable = false)
    private Long identificacion;
	
	@Column(name = "direccion", nullable = false)
    private String direccion;
	
	@Column(name = "telefono", nullable = false)
    private String telefono;

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

}
