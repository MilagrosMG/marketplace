package edu.es.eoi.marketplace.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.marketplace.dto.ArticulosPedidoDto;
import edu.es.eoi.marketplace.dto.PedidoDto;
import edu.es.eoi.marketplace.entity.ArticulosPedido;
import edu.es.eoi.marketplace.entity.Pedido;
import edu.es.eoi.marketplace.repository.ArticuloRepository;
import edu.es.eoi.marketplace.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PedidoRepository pedidoRepo;
	
	@Autowired
	ArticuloRepository articuloRepo;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public PedidoDto entityToDto(Pedido entity) {
		
		PedidoDto dto = new PedidoDto();
		dto.setId(String.valueOf(entity.getId()));
		dto.setNombre(entity.getNombre());
		dto.setFecha(entity.getFecha().format(formatter));
		
		List<ArticulosPedido> articulosPedido = entity.getArticulosPedido();
		List<ArticulosPedidoDto> articulosPedidoDto =new ArrayList<ArticulosPedidoDto>();

		
		for (ArticulosPedido articulo : articulosPedido) {
			ArticulosPedidoDto dtoTemp = new ArticulosPedidoDto();
			dtoTemp.setId(String.valueOf(articulo.getId()));
			dtoTemp.setCantidad(String.valueOf(articulo.getCantidad()));
			articulosPedidoDto.add(dtoTemp);
		}
		
		dto.setArticulos(articulosPedidoDto);
		return dto;
	}
	
	public Pedido dtoToEntity(PedidoDto dto) {

		Pedido pedido = new Pedido();
		pedido.setNombre(dto.getNombre());
		pedido.setFecha(LocalDate.parse(dto.getFecha(),formatter));
	
		List<ArticulosPedidoDto> articulosPedidoDto = dto.getArticulos();
		List<ArticulosPedido> articulosPedido =new ArrayList<ArticulosPedido>();
		
		for (ArticulosPedidoDto iDto : articulosPedidoDto) {
			ArticulosPedido articuloTemp = new ArticulosPedido();
			articuloTemp.setArticulo(articuloRepo.findById(Integer.parseInt(iDto.getId())).get());
			articuloTemp.setCantidad(Integer.valueOf(iDto.getCantidad()));
			articuloTemp.setPedido(pedido);
			articulosPedido.add(articuloTemp);
		}
		pedido.setArticulosPedido(articulosPedido);
		
		return pedido;
	}

	
	public PedidoDto findById(int id) {
		Pedido entity = pedidoRepo.findById(id).get();
		
		return entityToDto(entity);
	}

	
	public List <PedidoDto> findByNombreParcial(String nombre) {
		
		List <Pedido> pedidos = pedidoRepo.findByNombreContaining(nombre);
		List <PedidoDto> dtos = new ArrayList<PedidoDto> ();
		
		for (Pedido pedido : pedidos) {
			
			PedidoDto dto = new PedidoDto();
			dto.setId(String.valueOf(pedido.getId()));
			dto.setNombre(pedido.getNombre());
			dto.setFecha(pedido.getFecha().format(formatter));
			
			List<ArticulosPedidoDto> articulos = new ArrayList<ArticulosPedidoDto>();
			List<ArticulosPedido> articulosPedido = pedido.getArticulosPedido();
			
			
			for (ArticulosPedido articulo : articulosPedido) {
				ArticulosPedidoDto artTemp = new ArticulosPedidoDto();
				artTemp.setCantidad(String.valueOf(articulo.getCantidad()));
				artTemp.setId(String.valueOf(articulo.getId()));
				
				articulos.add(artTemp);
				dto.setArticulos(articulos);
			}
			dtos.add(dto);
		}
		return dtos;
	}


	public void deletePedido(PedidoDto dto) {
			Pedido pedido = pedidoRepo.findById(Integer.valueOf(dto.getId())).get();
			pedidoRepo.delete(pedido);
		
	}

	
	public Pedido createPedido(PedidoDto dto) {
		return pedidoRepo.save(dtoToEntity(dto));
	}


	public Pedido updatePedido(PedidoDto dto) {
		Pedido pedido= pedidoRepo.findById(Integer.valueOf(dto.getId())).get();
		pedido.setNombre(dto.getNombre());
		pedido.setFecha(LocalDate.parse(dto.getFecha(),formatter));
		
		List<ArticulosPedidoDto> articulosPedidoDto = dto.getArticulos();
		List<ArticulosPedido> articulosPedido =new ArrayList<ArticulosPedido>();
		
		for (ArticulosPedidoDto iDto : articulosPedidoDto) {
			ArticulosPedido articuloTemp = new ArticulosPedido();
			articuloTemp.setId(Integer.valueOf(iDto.getId()));
			articuloTemp.setCantidad(Integer.valueOf(iDto.getCantidad()));
			
			articulosPedido.add(articuloTemp);
		}
		
		pedido.setArticulosPedido(articulosPedido);
	
		
		return pedidoRepo.save(pedido);
		
	}
}
