package com.caracoles.saludback.model;

public class RegistroDTO {

	private String datetime;

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	@Override
	public String toString() {
		return "RegistroDTO [datetime=" + datetime + "]";
	}
	
	
	
}
