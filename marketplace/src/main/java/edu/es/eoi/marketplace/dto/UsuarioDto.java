package edu.es.eoi.marketplace.dto;

public class UsuarioDto {

	private String id;
	
	private String nombre;
	
	private String password;

	
	public UsuarioDto() {
		super();
	}

	public UsuarioDto(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
