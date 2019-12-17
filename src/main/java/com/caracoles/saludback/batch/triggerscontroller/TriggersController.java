package com.caracoles.saludback.batch.triggerscontroller;

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
	
	@Autowired
	@Qualifier("job2")
	private Job job;
	
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@GetMapping("")
	public String home() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		System.out.println("HOME");
		return triggerJob();
	}
	
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

