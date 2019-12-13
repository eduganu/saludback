package com.caracoles.saludback.ejemplo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.caracoles.saludback.model.Registro;
import com.caracoles.saludback.model.RegistroDTO;

@Component
public class JobRegistroProcessor implements ItemProcessor<RegistroDTO, Registro> {

	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
	
	@Override
	public Registro process(RegistroDTO item) throws Exception {
		System.out.println(item);
		
		Date parsedDate = new Date();
		
		
		final String datetime = item.getDatetime();
		
		try {
			parsedDate = dateFormat.parse(datetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Registro newRegistro = new Registro();
		newRegistro.setDatetime(parsedDate);
		System.out.println(newRegistro);
			
		
		return newRegistro;
	}

}
