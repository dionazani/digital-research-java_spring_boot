package org.dionazani.digitalresearch.domain.runningdigital;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RunningDigitalEntityCustom {

	@Id
	public UUID deliquencyStrategyId;
	public String strategyName;
	public String strategyChannel;
	public String deliquencyTime;
	public String regionName;
	public int regionOrder;
}
