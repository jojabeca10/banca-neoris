package com.api.bancaneoris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.api.bancaneoris.entity.Movimiento;
import com.api.bancaneoris.entity.Response;


@Repository
public interface IMovimientoRepository extends JpaRepository<Movimiento, Long> {
	@Query(value = "SELECT TOP 1 * FROM Movimiento WHERE num_cuenta =:numCuenta ORDER BY fecha DESC", nativeQuery = true)
	Movimiento getMovimientoAnterior(@Param("numCuenta") String numCuenta);
	
	@Query(value = "SELECT TOP 1 m.fecha, c.cliente, c.numero, c.tipo, c.saldo_inicial, c.estado, m.saldo FROM Cuenta c "
			+ "INNER JOIN Movimiento m ON c.numero = m.num_cuenta WHERE c.cliente =:cliente ORDER BY fecha DESC", nativeQuery = true)
	List<Object> getMovimiento(@Param("cliente") String cliente);
}
