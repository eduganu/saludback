package com.caracoles.saludback.model.dtos;

import java.util.Date;

public class PulsacionDTO {
	
	private Date datetime;
	private int bpm;
	
	public PulsacionDTO() {
		
	}
	
	public PulsacionDTO(Date datetime, int bpm) {
		this.datetime = datetime;
		this.bpm = bpm;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}

	@Override
	public String toString() {
		return "PulsacionDTO [datetime=" + datetime + ", bpm=" + bpm + "]";
	}
	
}
