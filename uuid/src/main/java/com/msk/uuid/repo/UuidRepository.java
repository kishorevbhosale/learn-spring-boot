package com.msk.uuid.repo;

import com.msk.uuid.model.UuidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UuidRepository extends JpaRepository<UuidEntity, Long> {
}
