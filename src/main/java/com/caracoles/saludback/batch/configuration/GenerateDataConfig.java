package com.caracoles.saludback.batch.configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.caracoles.saludback.model.Usuario;
import com.caracoles.saludback.repositories.UsuarioRepository;

@Configuration

public class GenerateDataConfig {
	
	private final static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public GenerateDataConfig() {
		
	}
	
	@Bean
	public void insertUsers() {
		
		Date d1 = new Date();
		Date d2 = new Date();
		Date d3 = new Date();
		
		try {
			d1 = format.parse("29-06-1986");
			d2 = format.parse("01-01-1992");
			d3 = format.parse("16-09-1989");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// TODO creación de usuarios de demo programaticamente
		
		Usuario usuarioVago = new Usuario();
		
		usuarioVago.setUserID(100L);
		usuarioVago.setNombre("Igor");
		usuarioVago.setApellido("Dito");
		usuarioVago.setSexo("Hombre");
		usuarioVago.setFechaNacimiento(d1); 
		usuarioVago.setAltura(1.74);
		usuarioVago.setPeso(89);
		usuarioVago.setProfesion("Repartidor");
		usuarioVago.setHobby("Jugar a la playstation");
		
		Usuario usuarioNormal = new Usuario();
		
		usuarioNormal.setUserID(50L);
		usuarioNormal.setNombre("María");
		usuarioNormal.setApellido("García");
		usuarioNormal.setSexo("Mujer");
		usuarioNormal.setFechaNacimiento(d2); 
		usuarioNormal.setAltura(1.66);
		usuarioNormal.setPeso(52);
		usuarioNormal.setProfesion("Administrivo");
		usuarioNormal.setHobby("Viajar");
		
		Usuario usuarioAtleta = new Usuario();
		
		usuarioAtleta.setUserID(120L);
		usuarioAtleta.setNombre("Alberto");
		usuarioAtleta.setApellido("Fuerte");
		usuarioAtleta.setSexo("Hombre");
		usuarioAtleta.setFechaNacimiento(d3); 
		usuarioAtleta.setAltura(1.82);
		usuarioAtleta.setPeso(89);
		usuarioAtleta.setProfesion("Programador Java");
		usuarioAtleta.setHobby("Deportes de aventura");
		
		
		usuarioRepository.save(usuarioVago);
		usuarioRepository.save(usuarioNormal);
		usuarioRepository.save(usuarioAtleta);
		
	}
	
}
