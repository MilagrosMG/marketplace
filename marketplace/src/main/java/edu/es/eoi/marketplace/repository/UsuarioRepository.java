package edu.es.eoi.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.es.eoi.marketplace.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public List <Usuario> findByNombreContaining (String nombre);
	
	public Usuario findByNombreAndPassword (String nombre, String password);
}
