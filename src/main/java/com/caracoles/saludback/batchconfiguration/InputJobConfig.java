package com.caracoles.saludback.batchconfiguration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.caracoles.saludback.model.Registro;

//@Configuration
public class InputJobConfig extends AbstractJobConfig {
	
	// Definimos el job
	
	@Bean
	public Job inputJob() {
		return jobBuilderFactory.get("inputJob")
				.flow(inputStep())
				.end()
				.build();
	}
	
	// Definimos el step
	
	public Step inputStep() {
		return stepBuilderFactory.get("step1")
				.<Registro,Registro> chunk(10)
				.reader(reader())
				.writer(writer())
				.build();
	}
	
	// Definimos el reader /Leemos CSV
	
	
	public FlatFileItemReader<Registro> reader(){

		FlatFileItemReaderBuilder<Registro> ffib = new FlatFileItemReaderBuilder<Registro>();
		
		FlatFileItemReader<Registro> ffir = ffib
				.name("reader1")
				.resource(new FileSystemResource("datos/facil.csv"))
				.linesToSkip(1)
				.delimited()
				.names(new String[] {"nombre"})
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Registro>() {{
					setTargetType(Registro.class);
				}}).build();				
		
		return ffir;
	}
	
	
	// Definimos el writer /Escribimos en la DB
	
	public JdbcBatchItemWriter<Registro> writer(){
		
		return new JdbcBatchItemWriterBuilder<Registro>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO DEMO (nombre) VALUES (:nombre)")
				.dataSource(dataSource)
				.build();
	
	}
		
}
