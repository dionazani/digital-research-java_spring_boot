package org.dionazani.digitalresearch.infrastructure.repository;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="deliquency_strategy")
public class DeliquencyStrategyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;
    
    private String strategyName;
    
    private String stratgeyChannel;
    
    private String deliquencyTime;
    
    private String deliquencyTimeGmt;
    
    private String deliquencyRegion;
    
    private String deliquencyPersonType;
}
