package edu.es.eoi.marketplace.service;

import java.util.List;

import edu.es.eoi.marketplace.dto.ArticuloDto;
import edu.es.eoi.marketplace.entity.Articulo;

public interface ArticuloService {

	public ArticuloDto entityToDto (Articulo entity);
	public Articulo dtoToEntity(ArticuloDto dto);
	
	public List<ArticuloDto> findByNombreParcial (String nombre);
	
	public ArticuloDto findById(int id);
	
	public Articulo createArticulo(ArticuloDto dto);
	
	public Articulo updateArticulo(ArticuloDto dto);
	
}

