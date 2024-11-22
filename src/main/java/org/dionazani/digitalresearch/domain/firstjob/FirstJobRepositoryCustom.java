package org.dionazani.digitalresearch.domain.firstjob;

import java.util.List;

import org.dionazani.digitalresearch.domain.runningdigital.RunningDigitalEntityCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class FirstJobRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	public List<FirstJobEntityCustom> getAgreementOmni(String businessDate) {
		
		String sql = "select agreement.id as agreement_id,\r\n"
				+ "		agreement.region,\r\n"
				+ "		agreement.business_date,\r\n"
				+ "		agreement_omni.id as agreement_omni_id\r\n"
				+ "from agreement left join agreement_omni on agreement_omni.agreement_id = agreement.id\r\n"
				+ "where to_char(agreement.business_date, 'yyyy-MM-dd') = :businessDate";
		
		List<FirstJobEntityCustom> firstJobEntityCustoms = this.em.createNativeQuery(sql, FirstJobEntityCustom.class)
											 				.setParameter("businessDate", businessDate)
															.getResultList();
		
		return firstJobEntityCustoms;
	}
}
