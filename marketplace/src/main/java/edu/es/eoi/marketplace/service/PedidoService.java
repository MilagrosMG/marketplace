package edu.es.eoi.marketplace.service;

import java.util.List;

import edu.es.eoi.marketplace.dto.PedidoDto;
import edu.es.eoi.marketplace.entity.Pedido;

public interface PedidoService {
	
	public PedidoDto entityToDto(Pedido entity);
	public Pedido dtoToEntity(PedidoDto dto);
	
	public PedidoDto findById(int id);
	
	public List <PedidoDto> findByNombreParcial (String nombre);
	
	public void deletePedido(PedidoDto dto);
	
	public Pedido createPedido(PedidoDto dto);
	
	public Pedido updatePedido(PedidoDto dto);
	
}
