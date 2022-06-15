package edu.es.eoi.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.es.eoi.marketplace.dto.UsuarioDto;
import edu.es.eoi.marketplace.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/marketplace/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDto>> findAll(){
		
			return new ResponseEntity<List<UsuarioDto>>(service.findAll(),HttpStatus.OK);
		}		
		 
	
	
	@RequestMapping (method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity <UsuarioDto> findById(@PathVariable Integer id) {
		
		return new ResponseEntity <UsuarioDto> (service.findById(id), HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody UsuarioDto dto) {
//
//		if (dto.getId().equals(null)) {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		} else {
			service.createUsuario(dto);
			return new ResponseEntity<>(HttpStatus.CREATED);
//		}

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody UsuarioDto usuario) {

		if (!usuario.getId().equals(id)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			service.updateUsuario(usuario);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "login")
	public ResponseEntity<UsuarioDto> login(@RequestBody UsuarioDto usuario) {
		UsuarioDto dto = service.findByLogin(usuario);
		if (dto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<UsuarioDto>(dto, HttpStatus.OK);
		}
	}

}
