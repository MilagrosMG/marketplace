package edu.es.eoi.marketplace.service;

import java.util.List;

import edu.es.eoi.marketplace.dto.UsuarioDto;
import edu.es.eoi.marketplace.entity.Usuario;

public interface UsuarioService {

	public UsuarioDto entityToDto (Usuario entity);
	public Usuario dtoToEntity(UsuarioDto dto);

	public List<UsuarioDto> findAll();
	
	public UsuarioDto findById(int id);
	
	public Usuario createUsuario(UsuarioDto dto);
	
	public UsuarioDto findByLogin (UsuarioDto usuarioDto);
	
	public Usuario updateUsuario(UsuarioDto dto);
}
 