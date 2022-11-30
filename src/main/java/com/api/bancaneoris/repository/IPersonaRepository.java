package com.api.bancaneoris.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.bancaneoris.entity.Cliente;
import com.api.bancaneoris.entity.Persona;


@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
	@Query(value = "SELECT p FROM Persona p WHERE p.identificacion =:identificacion")
	Cliente getPersona(@Param("identificacion") Long identificacion);
}
