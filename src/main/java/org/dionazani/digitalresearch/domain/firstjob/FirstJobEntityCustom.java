package org.dionazani.digitalresearch.domain.firstjob;

import java.sql.Date;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FirstJobEntityCustom {
	
	@Id
	public UUID agreementId;
	public String region;
	public Date businessDate;
	public UUID agreementOmniId;
}
