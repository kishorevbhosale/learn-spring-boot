package com.msk.snowflake_id_gen.controller;

import com.msk.snowflake_id_gen.service.SnowflakeIdGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SequencerController {

    private final SnowflakeIdGenerator idGenerator;

    public SequencerController(SnowflakeIdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @GetMapping("/id")
    public String getId() {
        return String.valueOf(idGenerator.nextId());
    }
}
