package org.dionazani.digitalresearch.domain.firstjob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FirstJobServiceImpl implements FirstJobService {

	@Override
	@Scheduled(fixedRateString = "${spring.scheduled.fixrate.firstjob}")
	public void runningTask() {
		// TODO Auto-generated method stub
		
	}

}
