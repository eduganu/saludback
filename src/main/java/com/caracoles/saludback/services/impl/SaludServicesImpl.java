package com.caracoles.saludback.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caracoles.saludback.model.Registro;
import com.caracoles.saludback.model.Usuario;
import com.caracoles.saludback.repositories.RegistroRepository;
import com.caracoles.saludback.repositories.UsuarioRepository;
//import com.caracoles.saludback.repositories.RegistroRepository;
import com.caracoles.saludback.services.SaludServices;

@Service
public class SaludServicesImpl implements SaludServices {
	
	@Autowired
	private RegistroRepository registroRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Registro> getAll() {
		return registroRepository.findAll();
	}

	@Override
	public int count() {
		return (int) registroRepository.count();
	}

	@Override
	public List<Registro> getByUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return registroRepository.getByUsuario(usuario);
	}

	@Override
	public List<Registro> getByUsuario(long id) {
		Usuario usuario = new Usuario();
		usuario.setUserID(id);
		return registroRepository.getByUsuario(usuario);
	}

	//   --------- USER METHODS ---------
	@Override
	public List<Usuario> getUsuarioById(long id) {
		System.out.println("la id que buscamos es: " + id);
		return usuarioRepository.getByUserID(id);
	}
	
}
