package com.caracoles.saludback.triggerscontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriggersController {

	// Neceistamos:
	
	// 1.- El job
	
	@Autowired
	@Qualifier("job2")
//	@Qualifier("inputJob")
	private Job job;
	
	
	@Autowired
	private JobLauncher jobLauncher;
	
	
	@GetMapping("/trigger")
	public String triggerJob() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		System.out.println("iniciamos job");
		
		JobParameter jobParameter = new JobParameter("p_" + System.currentTimeMillis());
		Map<String,JobParameter> parametersMap = new HashMap<>();
		parametersMap.put("p1", jobParameter);
		
		JobParameters jobParameters = new JobParameters(parametersMap);
		
		jobLauncher.run(job, jobParameters);
		
		return "OK";
	}
	
}
