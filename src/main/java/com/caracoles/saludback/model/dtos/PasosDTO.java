package com.caracoles.saludback.model.dtos;

import java.util.Date;

public class PasosDTO {
	
	private Date datetime;
	private int stepAccumulated;
	
	public PasosDTO() {
		
	}

	public PasosDTO(Date datetime, int stepAccumulated) {
		this.datetime = datetime;
		this.stepAccumulated = stepAccumulated;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public int getStepAccumulated() {
		return stepAccumulated;
	}

	public void setStepAccumulated(int stepAccumulated) {
		this.stepAccumulated = stepAccumulated;
	}

	@Override
	public String toString() {
		return "PasosDTO [datetime=" + datetime + ", stepAccumulated=" + stepAccumulated + "]";
	}
	
}
