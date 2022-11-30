package com.api.bancaneoris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bancaneoris.entity.Cliente;


@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
