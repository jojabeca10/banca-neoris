package com.api.bancaneoris.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.bancaneoris.entity.Cliente;
import com.api.bancaneoris.entity.Cuenta;
import com.api.bancaneoris.repository.ICuentaRepository;
import com.api.bancaneoris.repository.IPersonaRepository;
import com.api.bancaneoris.service.ICuentaService;
import com.api.bancaneoris.util.Util;

@Service
public class CuentaService implements ICuentaService {

	@Autowired
    private ICuentaRepository iCuentaRepository;
	@Autowired
    private IPersonaRepository iPersonaRepository;

	@Override
	public ResponseEntity<String> putCuenta(Cuenta cuenta) {
		try {
			if(Optional.ofNullable(cuenta).isPresent()) {
				if(!Optional.ofNullable(iCuentaRepository.getCuenta(cuenta.getNumero())).isPresent() &&
						Optional.ofNullable(cuenta.getIdentiCli()).isPresent()) {
					Cliente cliente = iPersonaRepository.getPersona(cuenta.getIdentiCli());
					if(!Optional.ofNullable(cliente).isPresent())
						return Util.buildResponse("Cliente Not found.", HttpStatus.BAD_REQUEST);
						
					cuenta.setCliente(cliente.getNombre());
					iCuentaRepository.save(cuenta);
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
	public ResponseEntity<String> deleteCuenta(Cuenta cuenta) {
		try {
			if(Optional.ofNullable(cuenta.getNumero()).isPresent()) {
					Cuenta data = iCuentaRepository.getCuenta(cuenta.getNumero());
					iCuentaRepository.delete(data);
					return Util.buildResponse("Delete ok", HttpStatus.OK);
			}
		}
		catch (Exception e) {
			return Util.buildResponse("Error..: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
