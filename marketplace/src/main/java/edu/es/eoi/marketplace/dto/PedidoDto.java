package edu.es.eoi.marketplace.dto;

import java.util.List;

public class PedidoDto {
	
	private String id;
	private String nombre;
	private String fecha;
	private List <ArticulosPedidoDto> articulos;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public List<ArticulosPedidoDto> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<ArticulosPedidoDto> articulos) {
		this.articulos = articulos;
	}
	
	
	
}
