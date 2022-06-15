package edu.es.eoi.marketplace.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "marketplace", name = "Articulo")
public class Articulo { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;

	@Column
	private Double precio;
	
	@Column
	private Integer stock;
	
	
	@OneToMany(mappedBy = "articulo", targetEntity = ArticulosPedido.class, cascade = CascadeType.ALL)
	private List <ArticulosPedido> articulosPedido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<ArticulosPedido> getArticulosPedido() {
		return articulosPedido;
	}

	public void setArticulosPedido(List<ArticulosPedido> articulosPedido) {
		this.articulosPedido = articulosPedido;
	}

	
	
	
}
