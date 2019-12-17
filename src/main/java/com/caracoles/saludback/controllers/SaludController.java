package com.caracoles.saludback.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caracoles.saludback.model.Registro;
import com.caracoles.saludback.model.Usuario;
import com.caracoles.saludback.model.dtos.EstadoDTO;
import com.caracoles.saludback.model.dtos.PasosDTO;
import com.caracoles.saludback.model.dtos.PulsacionDTO;
import com.caracoles.saludback.services.SaludServices;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SaludController {
	
	@Autowired
	private SaludServices saludServices;
	
	// ---------- CONTROLLERS PARA OBTENER REGISTROS -------------- //
	
	//Todos los registros de la base de datos
	@GetMapping("/registros")
	public List<Registro> getRegistros(){
		return saludServices.getAll();
	}
	
	// Numero de registros en la base de datos
	@GetMapping("registros/count")
	public int getCount() {
		return saludServices.countRegistros();
	}
	
	// Todos los registros de un usuario en un periodo de tiempo concreto
	@GetMapping("/registros/{userId}")
	public List<Registro> getRegistrosByUser(@PathVariable("userId") Long userId,
											 @RequestParam (value="desde", required=false) Date desde,
											 @RequestParam (value="hasta", required=false) Date hasta) {
		
		if (desde != null && hasta != null) {
			return saludServices.getRegistrosByUsuario(userId, desde, hasta);
		} else {
			return saludServices.getRegistrosByUsuario(userId);
		}
	}
	
	// ----------- CONTROLLERS PARA OBTENER USER INFORMATION ---------- //
	
	// Obtener un Usuario a traves de su ID
	@GetMapping("/usuarios/{usuarioID}")
	public List<Usuario> getUsuario(@PathVariable("usuarioID") Long usuarioID) {
		return saludServices.getUsuarioById(usuarioID);
	}
	
	// ----------- CONTROLLERS PARA OBTENER INFORMACION SOBRE BPM ---------- //
	
	// Historial de pulsaciones a partir de fecha
	@GetMapping("/registros/{userId}/bpm")
	public List<PulsacionDTO> getPulsaciones(@PathVariable ("userId") Long userId,
											 @RequestParam ("desde") Date desde,
											 @RequestParam (value="hasta", required=false) Date hasta) {
		if (hasta != null) {
			return saludServices.getUserBpm(userId, desde, hasta);
			
		} else {
			
			return saludServices.getUserBpm(userId, desde);
		}
	}
	
	// ----------- CONTROLLERS PARA OBTENER INFORMACION SOBRE PASOS ---------- //
	
	@GetMapping("/registros/{userId}/pasos")
	public List<PasosDTO> getPasos(	@PathVariable ("userId") Long userId,
									@RequestParam ("desde") Date desde,
									@RequestParam (value="hasta", required=false) Date hasta){
		if (hasta != null) {
			return saludServices.getUserPasos(userId, desde, hasta);
		} else {
			
			return saludServices.getUserPasos(userId, desde);
		
		}
	}
	
	// ----------- CONTROLLERS PARA OBTENER INFORMACION SOBRE PASOS ---------- //
	
	@GetMapping("/registros/{userId}/estados")
	public List<EstadoDTO> getEstados( @PathVariable ("userId") Long userId,
									   @RequestParam ("desde") Date desde,
									   @RequestParam (value="hasta", required=false) Date hasta){
		if (hasta != null) {
			return saludServices.getUserEstado(userId, desde, hasta);
		} else {
			
			return saludServices.getUserEstado(userId, desde);
		
		} 
	}

}
