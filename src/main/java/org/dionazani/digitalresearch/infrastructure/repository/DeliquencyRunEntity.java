package org.dionazani.digitalresearch.infrastructure.repository;

import java.util.Date;
import java.sql.Timestamp;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="deliquency_run")
public class DeliquencyRunEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;
    
    private Date businessDate;
    
    private UUID deliquencyStrategyId;
    
    private String status;
    
    @CreationTimestamp
    private Timestamp createdAt;
    
}
