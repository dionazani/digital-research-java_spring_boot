package org.dionazani.digitalresearch.infrastructure.entity;

import java.util.UUID;
import org.dionazani.digitalresearch.infrastructure.repository.DeliquencyStrategyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliquencyStrategyRepository extends JpaRepository<DeliquencyStrategyEntity, UUID>{

}
