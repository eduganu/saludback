package com.caracoles.saludback.model;

public class RegistroDTO {

	private String datetime;
	private int userID;
	private double bpm;
	private int stepAccumulated;
	private String setActivo;
	private double latitud;
	private double longitud;
	private int precisionGps;
	private int estado;

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	

	public double getBpm() {
		return bpm;
	}

	public void setBpm(double bpm) {
		this.bpm = bpm;
	}

	public int getStepAccumulated() {
		return stepAccumulated;
	}

	public void setStepAccumulated(int stepAccumulated) {
		this.stepAccumulated = stepAccumulated;
	}

	public String getSetActivo() {
		return setActivo;
	}

	public void setSetActivo(String setActivo) {
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
		return "RegistroDTO [datetime=" + datetime + ", userID=" + userID + ", bpm=" + bpm + ", stepAccumulated="
				+ stepAccumulated + ", setActivo=" + setActivo + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", precisionGps=" + precisionGps + ", estado=" + estado + "]";
	}
	
	
	
}
