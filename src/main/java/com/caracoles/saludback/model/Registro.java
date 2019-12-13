package com.caracoles.saludback.model;

import java.io.Serializable;
import java.util.Date;

public class Registro implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private Date datetime;
	/*private int userID;
	private int bpm;
	private int stepAccumulated;
	private double latitud;
	private double longitud;
	private int precisionGps;
	private int estado;
	*/
	
	//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
	/*try {
		//this.datetime = dateFormat.parse(datetime);
		Date parsedDate = dateFormat.parse(datetime);
	    this.datetime = new java.sql.Timestamp(parsedDate.getTime());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	
	public Date getDatetime() {
		return datetime;
	}
	
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	/*
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
				+ stepAccumulated + ", latitud=" + latitud + ", longitud=" + longitud + ", precisionGps=" + precisionGps
				+ ", estado=" + estado + "]";
	}
	
	*/

	@Override
	public String toString() {
		return "Registro [datetime=" + datetime + "]";
	}
	
	
	

}
