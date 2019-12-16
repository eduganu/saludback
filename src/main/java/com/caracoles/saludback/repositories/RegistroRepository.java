package com.caracoles.saludback.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caracoles.saludback.model.Registro;
import com.caracoles.saludback.model.Usuario;

public interface RegistroRepository extends JpaRepository<Registro, Long>{

	// Lo debería implementar automáticamente basándose en el nombre del método
	public List<Registro> getByUsuario(Usuario usuario);
	
	public List<Registro> getByUsuarioAndDatetimeBetween(Usuario usuario, Date inicio, Date fin);
	
	/*
	
	@Query("")
	public List<Registro> getByUserLatestWeek(Usuario usuario);
	
	*/
	
}
