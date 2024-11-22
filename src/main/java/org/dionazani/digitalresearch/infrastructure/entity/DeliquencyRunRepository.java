package org.dionazani.digitalresearch.infrastructure.entity;

import java.util.UUID;
import org.dionazani.digitalresearch.infrastructure.repository.DeliquencyRunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliquencyRunRepository extends JpaRepository<DeliquencyRunEntity, UUID>{

}
