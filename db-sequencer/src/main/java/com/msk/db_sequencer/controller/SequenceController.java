package com.msk.db_sequencer.controller;

import com.msk.db_sequencer.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SequenceController {

    @Autowired
    private SequenceService sequenceService;

    @GetMapping("/sequence/{name}")
    public Long getNextSequence(@PathVariable String name) {
        return sequenceService.getNextSequence(name);
    }

}
