package com.msk.db_sequencer.service;

import com.msk.db_sequencer.model.SequenceGenerator;
import com.msk.db_sequencer.repo.SequenceGeneratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequenceService {

    @Autowired
    private SequenceGeneratorRepo generatorRepo;

    public synchronized Long getNextSequence(String sequenceName) {
        SequenceGenerator sequence = generatorRepo
                .findByName(sequenceName)
                .orElseThrow(() -> new RuntimeException("Sequence not found: " + sequenceName));
        Long nextVal = sequence.getCurrentValue() + 1;
        sequence.setCurrentValue(nextVal);
        generatorRepo.save(sequence);

        return nextVal;
    }
}
