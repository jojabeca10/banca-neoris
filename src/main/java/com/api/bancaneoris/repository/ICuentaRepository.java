package com.api.bancaneoris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.api.bancaneoris.entity.Cuenta;


@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Long> {
	@Query(value = "SELECT c FROM Cuenta c WHERE c.numero =:numero")
	Cuenta getCuenta(@Param("numero") String numero);
}
