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

import edu.es.eoi.marketplace.dto.PedidoDto;
import edu.es.eoi.marketplace.service.PedidoServiceImpl;

@RestController
@RequestMapping ("/marketplace/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoServiceImpl service;
	
	@RequestMapping (method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity <?> findById(@PathVariable String id) {
		
		try {
			Integer pk= Integer.parseInt(id);
			return new ResponseEntity <PedidoDto> (service.findById(pk), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity <List<PedidoDto>> (service.findByNombreParcial(id), HttpStatus.OK);

		}
	}
	
//	@RequestMapping (method = RequestMethod.GET, value = "/{nombreparcial}")
//	public ResponseEntity <List<PedidoDto>> findByNombreParcial(@PathVariable String nombre) {
//		
//		return new ResponseEntity <List<PedidoDto>> (service.findByNombreParcial(nombre), HttpStatus.OK);
//	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {

		PedidoDto pedido = service.findById(id);
		service.deletePedido(pedido);

		return new ResponseEntity<>(HttpStatus.ACCEPTED);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody PedidoDto dto) {
//
//		if (dto.getId().equals(null)) {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		} else {
			service.createPedido(dto);
			return new ResponseEntity<>(HttpStatus.CREATED);
//		}

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody PedidoDto pedido) {

		if (!pedido.getId().equals(id)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			service.updatePedido(pedido);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}

	}
}
