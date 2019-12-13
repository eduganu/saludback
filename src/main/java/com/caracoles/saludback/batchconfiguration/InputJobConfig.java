package com.caracoles.saludback.batchconfiguration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.caracoles.saludback.model.Registro;
import com.caracoles.saludback.model.RegistroDTO;

@Configuration
public class InputJobConfig extends AbstractJobConfig {

	@Autowired
	private ItemProcessor<RegistroDTO, Registro> processor;
		
	@Bean
	public Job job2() {
		return jobBuilderFactory.get("job2")
				.flow(step2())
				.end()
				.build();
	}
		
	@Bean
	public Step step2() {
		return stepBuilderFactory.get("step2")
				.<RegistroDTO,Registro> chunk(5)
				.reader(reader2())
				.processor(processor)
				.writer(writer2())
				.build();
	}
	
	public FlatFileItemReader<RegistroDTO> reader2(){
		return new FlatFileItemReaderBuilder<RegistroDTO>()
			.name("reader2")
			.resource(new FileSystemResource("materiales/entradas/registros.csv"))
			.linesToSkip(1)
			.delimited()
			.names(new String[] {"datetime","userID", "bpm", "stepAccumulated", "setActivo", "latitud", "longitud", "precisionGps", "estado"})//"userID", "bpm", "stepAccumulated", "latitud", "longitud", "precisionGps", "estado"
			.fieldSetMapper(new BeanWrapperFieldSetMapper<RegistroDTO>(){{
				setTargetType(RegistroDTO.class);
			}}).build();
	}
	
	@Bean
	public JdbcBatchItemWriter<Registro> writer2(){
		return new JdbcBatchItemWriterBuilder<Registro>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO REGISTROS (datetime, user_id, bpm, step_acc, set_activo, latitud, longitud, precision, estado) VALUES (:datetime, :userID, :bpm, :stepAccumulated, :setActivo, :latitud, :longitud, :precisionGps, :estado)")
				.dataSource(dataSource)
				.build();
	}
}

