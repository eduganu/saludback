package com.caracoles.saludback.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="REGISTROS")
public class Registro implements Serializable {
	private static final long serialVersionUID = -1L;
	
	@Id
	private Date datetime;
		
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Usuario usuario;
	
	private int bpm;
	
	@Column(name="STEP_ACC")
	private int stepAccumulated;
	
	private boolean setActivo;
	private double latitud;
	private double longitud;
	
	@Column(name="PRECISION")
	private int precisionGps;
	
	private int estado;
	
	public Registro() {
		
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}

	public int getStepAccumulated() {
		return stepAccumulated;
	}

	public void setStepAccumulated(int stepAccumulated) {
		this.stepAccumulated = stepAccumulated;
	}

	public boolean isSetActivo() {
		return setActivo;
	}

	public void setSetActivo(boolean setActivo) {
		this.setActivo = setActivo;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public int getPrecisionGps() {
		return precisionGps;
	}

	public void setPrecisionGps(int precisionGps) {
		this.precisionGps = precisionGps;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Registro [datetime=" + datetime + ", usuario=" + usuario + ", bpm=" + bpm + ", stepAccumulated="
				+ stepAccumulated + ", setActivo=" + setActivo + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", precisionGps=" + precisionGps + ", estado=" + estado + "]";
	}
	
}
