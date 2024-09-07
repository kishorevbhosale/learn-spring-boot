package com.msk.db_sequencer.repo;

import com.msk.db_sequencer.model.SequenceGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SequenceGeneratorRepo extends JpaRepository<SequenceGenerator, Long> {
    Optional<SequenceGenerator> findByName(String name);
}
