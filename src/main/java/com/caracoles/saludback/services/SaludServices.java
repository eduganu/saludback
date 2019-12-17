package com.caracoles.saludback.services;

import java.util.Date;
import java.util.List;

import com.caracoles.saludback.model.Registro;
import com.caracoles.saludback.model.Usuario;
import com.caracoles.saludback.model.dtos.EstadoDTO;
import com.caracoles.saludback.model.dtos.PasosDTO;
import com.caracoles.saludback.model.dtos.PulsacionDTO;

public interface SaludServices {
	
	// Todos los registros de la base de datos
	public List<Registro> getAll();
	
	// Numero de registros en la base de datos
	public int countRegistros();
	
	
	// Todos los registros de un mismo usuario (
	public List<Registro> getRegistrosByUsuario(long userId);
	
	// Todos los registros de un usuario pasando la ID como parametro) en un periodo de tiempo concreto
	public List<Registro> getRegistrosByUsuario(long userId, Date inicio, Date fin);
	
	// ----------- USER METHODS ------------ //
	
	// Obtener un Usuario a traves de su ID
	public List<Usuario> getUsuarioById(long id);
	
	// ----------- SERVICIOS PARA BPM ---------- //
	
	// Historial de pulsaciones a partir de una fecha
	public List<PulsacionDTO> getUserBpm(long userId, Date desde);
	
	// Historial de pulsaciones entre fechas definidas
	public List<PulsacionDTO> getUserBpm(long userId, Date desde, Date hasta);
	
	// ----------- SERVICIOS PARA PASOS ---------- //
	
	// Historial de pasos desde una fecha hasta ahora (por usuario)
	public List<PasosDTO> getUserPasos(long userId, Date desde);
	
	// Historial de pasos entre fechas definidas
	public List<PasosDTO> getUserPasos(long userId, Date desde, Date hasta);
	
	// ----------- SERVICIOS PARA ESTADOS ---------- //
	
	// Historial de pasos desde una fecha hasta ahora (por usuario)
	public List<EstadoDTO> getUserEstado(long userId, Date desde);
	
	// Historial de pasos entre fechas definidas
	public List<EstadoDTO> getUserEstado(long userId, Date desde, Date hasta);
}
