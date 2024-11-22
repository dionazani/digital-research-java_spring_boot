package org.dionazani.digitalresearch.domain.runningdigital;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.dionazani.digitalresearch.infrastructure.entity.DeliquencyRunRepository;
import org.dionazani.digitalresearch.infrastructure.repository.DeliquencyRunEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@EnableAsync
public class RunningDigitalServiceImpl implements RunningDigitalService{

	@Autowired
	private RunningDigitalRepositoryCustom runningWitRepositoryCustom;
	
	@Autowired
	private DeliquencyRunRepository deliquencyRunRepository;
	
	@Override
	@Scheduled(fixedRateString = "${spring.scheduled.fixrate.wit}")
	public void runningTask() {
	
		String myTime = "06:00";
		String regionName = "WIT";
		
		// get businessDate and currentDate
		String currentBusinessDate = this.getBusinessDate();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = null;
		try {
			currentDate = formatter.parse(currentBusinessDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// get deliquency strategy run on specific time.
		List<RunningDigitalEntityCustom> runningWitEntityCustoms = this.runningWitRepositoryCustom.getStrategyByTime(currentBusinessDate,
																														myTime,
																														regionName);
	
		// execute digital run.
		for (RunningDigitalEntityCustom entity : runningWitEntityCustoms) {
			var deliquencyRunEntity = new DeliquencyRunEntity();
			deliquencyRunEntity.setDeliquencyStrategyId(entity.getDeliquencyStrategyId());
			deliquencyRunEntity.setBusinessDate(currentDate);
			deliquencyRunEntity.setStatus("RUN");
			
			deliquencyRunRepository.save(deliquencyRunEntity);

		}
	
	}
	
	private String getBusinessDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	private String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
}
