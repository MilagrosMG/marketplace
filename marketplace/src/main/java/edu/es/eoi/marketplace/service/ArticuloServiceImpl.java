package edu.es.eoi.marketplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.marketplace.dto.ArticuloDto;
import edu.es.eoi.marketplace.entity.Articulo;
import edu.es.eoi.marketplace.repository.ArticuloRepository;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	ArticuloRepository articuloRepo;
	
	public ArticuloDto entityToDto(Articulo entity) {

		ArticuloDto dto = new ArticuloDto();
		dto.setId(String.valueOf(entity.getId()));
		dto.setNombre(entity.getNombre());
		dto.setPrecio(entity.getPrecio());
		dto.setStock(entity.getStock());
		return dto;
	}
	
	public Articulo dtoToEntity(ArticuloDto dto) {

		Articulo articulo = new Articulo();
		articulo.setNombre(dto.getNombre());
		articulo.setPrecio(dto.getPrecio());
		articulo.setStock(dto.getStock());
		return articulo;
	}
	
	public ArticuloDto findById(int id) {
		
		return entityToDto (articuloRepo.findById(id).get());
	}


	public List <ArticuloDto> findByNombreParcial(String nombre) {

		List<Articulo> articulos = articuloRepo.findByNombreContaining(nombre);
		List<ArticuloDto> dtos = new ArrayList<ArticuloDto>();

		for (Articulo articulo : articulos) {
			ArticuloDto dto = new ArticuloDto();
			dto.setId(String.valueOf(articulo.getId()));
			dto.setNombre(articulo.getNombre());
			dto.setPrecio(articulo.getPrecio());
			dto.setStock(articulo.getStock());
			dtos.add(dto);
		}
		
		return dtos;
	}


	public Articulo createArticulo(ArticuloDto dto) {
		return articuloRepo.save(dtoToEntity(dto));
	}


	public Articulo updateArticulo(ArticuloDto dto) {
		Articulo articulo= articuloRepo.findById(Integer.valueOf(dto.getId())).get();
		articulo.setNombre(dto.getNombre());
		articulo.setPrecio(dto.getPrecio());
		articulo.setStock(dto.getStock());
		
		return articuloRepo.save(articulo);
	}
}
