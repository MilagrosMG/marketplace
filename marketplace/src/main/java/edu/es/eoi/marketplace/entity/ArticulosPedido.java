package edu.es.eoi.marketplace.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "marketplace", name = "Pertenece_a")
public class ArticulosPedido {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;

	@Column
	private int cantidad;
	
//	@Column (name= "id_articulo")
	@JoinColumn(name = "id_articulo", referencedColumnName = "id")
	@ManyToOne()
	private Articulo articulo;
	
//	@Column (name= "id_pedido")
	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
	@ManyToOne()
	private Pedido pedido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
	
}