package com.caracoles.saludback.model;

import java.io.Serializable;
import java.util.Date;

public class Registro implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private Date datetime;
	private int userID;
	private int bpm;
	private int stepAccumulated;
	private boolean setActivo;
	private double latitud;
	private double longitud;
	private int precisionGps;
	private int estado;
	
	public Date getDatetime() {
		return datetime;
	}
	
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Registro [datetime=" + datetime + ", userID=" + userID + ", bpm=" + bpm + ", stepAccumulated="
				+ stepAccumulated + ", setActivo=" + setActivo + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", precisionGps=" + precisionGps + ", estado=" + estado + "]";
	}
	
}
