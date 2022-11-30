package com.api.bancaneoris.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.bancaneoris.entity.Cliente;
import com.api.bancaneoris.repository.IPersonaRepository;
import com.api.bancaneoris.service.IPersonaService;
import com.api.bancaneoris.util.Util;

@Service
public class ClienteService implements IPersonaService {

	@Autowired
    private IPersonaRepository iPersonaRepository;

	@Override
	public ResponseEntity<String> putCliente(Cliente cliente) {
		try {
			if(Optional.ofNullable(cliente).isPresent()) {
				if(!Optional.ofNullable(iPersonaRepository.getPersona(cliente.getIdentificacion())).isPresent()) {
					iPersonaRepository.save(cliente);
					return Util.buildResponse("Put ok", HttpStatus.OK);
				}
				else {
					return Util.buildResponse("Already exists", HttpStatus.BAD_REQUEST);
				}
			}
		}
		catch (Exception e) {
			return Util.buildResponse("Error..: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return null;
	}

	@Override
	public ResponseEntity<String> deleteCliente(Cliente cliente) {
		try {
			if(Optional.ofNullable(cliente.getIdentificacion()).isPresent()) {
					Cliente cli = iPersonaRepository.getPersona(cliente.getIdentificacion());
					iPersonaRepository.delete(cli);
					return Util.buildResponse("Delete ok", HttpStatus.OK);
			}
		}
		catch (Exception e) {
			return Util.buildResponse("Error..: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
