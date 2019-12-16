package com.caracoles.saludback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.caracoles.saludback.model.Registro;
import com.caracoles.saludback.model.Usuario;
import com.caracoles.saludback.services.SaludServices;

@RestController
public class SaludController {
	
	@Autowired
	private SaludServices saludServices;
	
	@GetMapping("/registros")
	public List<Registro> getRegistros(){
		return saludServices.getAll();
	}
	
	@GetMapping("/count")
	public int getCount() {
		return saludServices.count();
	}
	
	@GetMapping("/registros/{usuario}")
	public List<Registro> getRegistros(@PathVariable("usuario") Long usuario){
		return saludServices.getByUsuario(usuario);
	}
	
	
	// ----------- USER INFORMATION ---------- //
	@GetMapping("/usuarios/{usuarioID}")
	public List<Usuario> getUsuario(@PathVariable("usuarioID") Long usuarioID) {
		return saludServices.getUsuarioById(usuarioID);
	}

}
