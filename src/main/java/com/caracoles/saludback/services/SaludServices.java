package com.caracoles.saludback.services;

import java.util.Date;
import java.util.List;

import com.caracoles.saludback.model.Registro;
import com.caracoles.saludback.model.Usuario;

public interface SaludServices {
	
	public List<Registro> getAll();
	
	public int countRegistros();
	
	public List<Registro> getByUsuario(Usuario usuario);
	
	public List<Registro> getByUsuario(long id);
	
	public List<Registro> getByUserBetweenDays(long userID, String inicio, String fin);
	
	
	// ----------- USER METHODS ------------ //
	
	public List<Usuario> getUsuarioById(long id);

}
