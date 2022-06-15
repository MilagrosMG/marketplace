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

import edu.es.eoi.marketplace.dto.ArticuloDto;
import edu.es.eoi.marketplace.service.ArticuloServiceImpl;

@RestController
@RequestMapping ("/marketplace")
public class ArticuloController {

	@Autowired
	private ArticuloServiceImpl service;
	
	
//	@RequestMapping (method = RequestMethod.GET, value = "/articulos/nombre/{nombreparcial}")
//	public ResponseEntity <List<ArticuloDto>> findByNombreParcial(@PathVariable String nombreparcial) {
//		
//		return new ResponseEntity<List<ArticuloDto>> (service.findByNombreParcial(nombreparcial), HttpStatus.OK);
//	}
	  
	
	@RequestMapping (method = RequestMethod.GET, value = "/articulos/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		
		try {
			Integer pk= Integer.parseInt(id);
			return new ResponseEntity <ArticuloDto> (service.findById(pk), HttpStatus.OK);

		} catch (Exception e) {
		return new ResponseEntity <List<ArticuloDto>> (service.findByNombreParcial(id), HttpStatus.OK);

		}
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value = "/articulo")
	public ResponseEntity<?> create(@RequestBody ArticuloDto dto) {
//
//		if (dto.getId().equals(null)) {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		} else {
			service.createArticulo(dto);
			return new ResponseEntity<>(HttpStatus.CREATED);
//		}

	}
	
	@RequestMapping(value = "/articulos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody ArticuloDto articulo) {

		if (!articulo.getId().equals(id)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			service.updateArticulo(articulo);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}

	}
	
	
}
