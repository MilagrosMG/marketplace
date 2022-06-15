package edu.es.eoi.marketplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.es.eoi.marketplace.dto.UsuarioDto;
import edu.es.eoi.marketplace.entity.Usuario;
import edu.es.eoi.marketplace.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepo;
	
	public UsuarioDto entityToDto(Usuario entity) {

		UsuarioDto dto = new UsuarioDto();
		dto.setId(String.valueOf(entity.getId()));
		dto.setNombre(entity.getNombre());
		dto.setPassword(entity.getPassword());
		return dto;
	}
	
	public Usuario dtoToEntity(UsuarioDto dto) {

		Usuario usuario = new Usuario();
		usuario.setNombre(dto.getNombre());
		usuario.setPassword(dto.getPassword());
		return usuario;
	}


	public List<UsuarioDto> findAll() {

		List<Usuario> usuarios = usuarioRepo.findAll();
		List<UsuarioDto> dtos = new ArrayList<UsuarioDto>();

		for (Usuario usuario : usuarios) {

			UsuarioDto dto = new UsuarioDto();
			dto.setId(String.valueOf(usuario.getId()));
			dto.setNombre(usuario.getNombre());
			dto.setPassword(usuario.getPassword());
			dtos.add(dto);
		}
		return dtos;

	}
	
	public UsuarioDto findById(int id) {

		return entityToDto(usuarioRepo.findById(id).get());
	}
	
	public Usuario createUsuario(UsuarioDto dto) {
	
		return usuarioRepo.save(dtoToEntity(dto));
	}

	public UsuarioDto findByLogin(UsuarioDto usuarioDto) {

		Usuario entity = usuarioRepo.findByNombreAndPassword(usuarioDto.getNombre(), usuarioDto.getPassword());

		if (entity != null) {
			UsuarioDto dto = new UsuarioDto();
			dto.setId(String.valueOf(entity.getId()));
			dto.setNombre(entity.getNombre());
			dto.setPassword(entity.getPassword());
			return dto;
		} else {
			return null;
		}

	}
	
	public Usuario updateUsuario(UsuarioDto dto) {
		Usuario usuario= usuarioRepo.findById(Integer.valueOf(dto.getId())).get();
		usuario.setNombre(dto.getNombre());
		usuario.setPassword(dto.getPassword());
		
		return usuarioRepo.save(usuario);
	}
}
