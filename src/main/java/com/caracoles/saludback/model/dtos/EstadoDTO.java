package com.caracoles.saludback.model.dtos;

import java.util.Date;

public class EstadoDTO {
	
	private Date datetime;
	private int estado;
	
	public EstadoDTO() {
		
	}
	
	public EstadoDTO(Date datetime, int estado) {
		this.datetime = datetime;
		this.estado = estado;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "EstadoDTO [datetime=" + datetime + ", estado=" + estado + "]";
	}	

}
