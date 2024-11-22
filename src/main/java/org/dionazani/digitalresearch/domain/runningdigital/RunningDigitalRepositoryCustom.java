package org.dionazani.digitalresearch.domain.runningdigital;

import java.sql.Date;
import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RunningDigitalRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	public List<RunningDigitalEntityCustom> getStrategyByTime(String bussinessDate,
															String myTime,
															String regionName) {
		String sql = "select deliquency_strategy.id as deliquency_strategy_id,\r\n"
				+ "			deliquency_strategy.strategy_name,\r\n"
				+ "			deliquency_strategy.strategy_channel,\r\n"
				+ "			deliquency_strategy.deliquency_time,\r\n"
				+ "			region.region_name,\r\n"
				+ "			region.region_order,\r\n"
				+ "			deliquency_run.id as deliquency_run_id,\r\n"
				+ "			deliquency_run.business_date\r\n"
				+ "from deliquency_strategy inner join region on region.id = deliquency_strategy.region_id\r\n"
				+ "		left join deliquency_run on deliquency_run.deliquency_strategy_id = deliquency_strategy.id\r\n"
				+ "			and to_char(deliquency_run.business_date,'yyyy-MM-dd') = :bussinessDate \r\n"
				+ "			where deliquency_time <= :myTime \r\n"
				+" 			and region.region_name = :regionName \r\n"
				+ "			order by deliquency_time desc\r\n"
				+ "			limit 1";
		
		List<RunningDigitalEntityCustom> runningWitEntityCustomList = this.em.createNativeQuery(sql, RunningDigitalEntityCustom.class)
																.setParameter("bussinessDate", bussinessDate)
																.setParameter("myTime", myTime)
												 				.setParameter("regionName", regionName)
																.getResultList();
		
		return runningWitEntityCustomList;
																
	}
}
