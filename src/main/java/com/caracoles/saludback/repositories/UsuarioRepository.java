package com.caracoles.saludback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caracoles.saludback.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

	public List<Usuario> getByUserID(long id);
	
	public List<Usuario> getByNombre(String nombre);
	
	public List<Usuario> getByNombreAndApellido(String nombre, String apellido);
	
	
}
