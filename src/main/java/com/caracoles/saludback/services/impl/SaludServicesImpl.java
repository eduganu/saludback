package com.caracoles.saludback.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caracoles.saludback.model.Registro;
import com.caracoles.saludback.model.Usuario;
import com.caracoles.saludback.model.dtos.EstadoDTO;
import com.caracoles.saludback.model.dtos.PasosDTO;
import com.caracoles.saludback.model.dtos.PulsacionDTO;
import com.caracoles.saludback.repositories.RegistroRepository;
import com.caracoles.saludback.repositories.UsuarioRepository;
//import com.caracoles.saludback.repositories.RegistroRepository;
import com.caracoles.saludback.services.SaludServices;

@Service
public class SaludServicesImpl implements SaludServices {
	
	//private final static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private RegistroRepository registroRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	// Todos los registros de la base de datos
	@Override
	public List<Registro> getAll() {
		return registroRepository.findAll();
	}

	// Numero de registros en la base de datos
	@Override
	public int countRegistros() {
		return (int) registroRepository.count();
	}

	// Todos los registros de un mismo usuario (pasando la ID como parametro)
	@Override
	public List<Registro> getRegistrosByUsuario(long userId) {
		Usuario usuario = new Usuario();
		usuario.setUserID(userId);
		return registroRepository.getByUsuario(usuario);
	}
	
	// Todos los registros de un usuario en un periodo de tiempo concreto
	@Override
	public List<Registro> getRegistrosByUsuario(long userID, Date desde, Date hasta) {
		
		Usuario usuario = new Usuario();
		usuario.setUserID(userID);
		
		return registroRepository.getByUsuarioAndDatetimeBetween(usuario, desde, hasta);
	}
	
	//  --------- USER METHODS --------- //
	
	// Obtener un Usuario a traves de su ID
	@Override
	public List<Usuario> getUsuarioById(long id) {
		//System.out.println("la id que buscamos es: " + id);
		return usuarioRepository.getByUserID(id);
	}
	
	// ----------- SERVICIOS PARA BPM ---------- //
	
	// Historial de pulsaciones desde una fecha
	@Override
	public List<PulsacionDTO> getUserBpm(long userId, Date desde) {	
		return registroRepository.findPulsacionesFromDate(userId, desde);
	}
	
	// Historial de pulsaciones entre fechas definidas
	@Override
	public List<PulsacionDTO> getUserBpm(long userId, Date desde, Date hasta) {	
		return registroRepository.findPulsacionesBetweenDates(userId, desde, hasta);
	}
	
	
	//   --------- 	SERVICIOS PARA PASOS --------- //
	
	// Historial de pasos desde una fecha
	@Override
	public List<PasosDTO> getUserPasos(long userId, Date desde) {
		return registroRepository.findPasosFromDate(userId, desde);
	}
	
	// Historial de pasos entre fechas definidas
	@Override
	public List<PasosDTO> getUserPasos(long userId, Date desde, Date hasta) {
		return registroRepository.findPasosFromDate(userId, desde, hasta);
	}
	
	// ----------- SERVICIOS PARA ESTADOS ---------- //

	// Historial de estados desde una fecha
	@Override
	public List<EstadoDTO> getUserEstado(long userId, Date desde) {
		return registroRepository.findEstadoFromDate(userId, desde);
	}

	// Historial de estados entre fechas definidas
	@Override
	public List<EstadoDTO> getUserEstado(long userId, Date desde, Date hasta) {
		return registroRepository.findEstadoFromBetweenDates(userId, desde, hasta);
	}

}
	

