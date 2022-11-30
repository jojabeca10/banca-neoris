package com.api.bancaneoris.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cliente extends Persona {
	
	@Column(name = "contrasena", nullable = false)
    private String contrasena;
	
	@Column(name = "estado", nullable = false)
    private boolean estado;
}
