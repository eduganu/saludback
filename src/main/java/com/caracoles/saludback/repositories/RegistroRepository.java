package com.caracoles.saludback.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caracoles.saludback.model.Registro;
import com.caracoles.saludback.model.Usuario;
import com.caracoles.saludback.model.dtos.EstadoDTO;
import com.caracoles.saludback.model.dtos.PasosDTO;
import com.caracoles.saludback.model.dtos.PulsacionDTO;

public interface RegistroRepository extends JpaRepository<Registro, Long>{

	// Lo debería implementar automáticamente basándose en el nombre del método
	public List<Registro> getByUsuario(Usuario usuario);
	
	public List<Registro> getByUsuarioAndDatetimeBetween(Usuario usuario, Date inicio, Date fin);
	
	public List<Registro> findByUsuarioAndDatetimeAfter(Usuario usuario, Date inicio);
	
	// Queries Pulsaciones
	@Query("select new com.caracoles.saludback.model.dtos.PulsacionDTO(r.datetime, r.bpm) from Registro r where r.usuario.userID = :userId AND r.datetime > :desde order by r.datetime")
	public List<PulsacionDTO> findPulsacionesFromDate(@Param("userId") long userId, @Param ("desde") Date desde);
	
	@Query("select new com.caracoles.saludback.model.dtos.PulsacionDTO(r.datetime, r.bpm) from Registro r where r.usuario.userID = :userId AND r.datetime > :desde AND r.datetime < :hasta order by r.datetime")
	public List<PulsacionDTO> findPulsacionesBetweenDates(@Param("userId") long userId, @Param ("desde") Date desde, @Param ("hasta") Date hasta);
	
	// Queries Pasos
	@Query("select new com.caracoles.saludback.model.dtos.PasosDTO(r.datetime, r.stepAccumulated) from Registro r where r.usuario.userID = :userId AND r.datetime > :desde order by r.datetime")
	public List<PasosDTO> findPasosFromDate(@Param("userId") long userId, @Param ("desde") Date desde);
	
	@Query("select new com.caracoles.saludback.model.dtos.PasosDTO(r.datetime, r.stepAccumulated) from Registro r where r.usuario.userID = :userId AND r.datetime > :desde AND r.datetime < :hasta order by r.datetime")
	public List<PasosDTO> findPasosFromDate(@Param("userId") long userId, @Param ("desde") Date desde, @Param ("hasta") Date hasta);
	
	// Queries Estados
	@Query("select new com.caracoles.saludback.model.dtos.EstadoDTO(r.datetime, r.estado) from Registro r where r.usuario.userID = :userId AND r.datetime > :desde order by r.datetime")
	public List<EstadoDTO> findEstadoFromDate(@Param("userId") long userId, @Param ("desde") Date desde);
	
	@Query("select new com.caracoles.saludback.model.dtos.EstadoDTO(r.datetime, r.estado) from Registro r where r.usuario.userID = :userId AND r.datetime > :desde AND r.datetime < :hasta order by r.datetime")
	public List<EstadoDTO> findEstadoFromBetweenDates(@Param("userId") long userId, @Param ("desde") Date desde, Date hasta);
	
	
}
