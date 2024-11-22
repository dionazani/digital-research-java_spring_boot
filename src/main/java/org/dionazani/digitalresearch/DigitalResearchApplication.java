package org.dionazani.digitalresearch;

import org.dionazani.digitalresearch.domain.runningdigital.RunningDigitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DigitalResearchApplication {

	private static Logger LOG = LoggerFactory.getLogger(SpringBootApplication.class);
	
	@Autowired
	private RunningDigitalService runningDigitalService;
	
	public static void main(String[] args) {
		LOG.info("STARTING APPLICATION");
		SpringApplication.run(DigitalResearchApplication.class, args);
	}

}
