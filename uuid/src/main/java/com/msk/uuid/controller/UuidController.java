package com.msk.uuid.controller;

import com.msk.uuid.model.UuidEntity;
import com.msk.uuid.service.UuidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/uuids")
public class UuidController {

    @Autowired
    private UuidService uuidService;

    @PostMapping("/generate")
    public ResponseEntity<UuidEntity> generateUuid(){
        UuidEntity uuidEntity = uuidService.generateAndSaveUuid();
        return ResponseEntity.ok(uuidEntity);
    }

    @GetMapping
    public ResponseEntity<List<UuidEntity>> getAllUuids() {
        List<UuidEntity> uuids = uuidService.getAllUuids();
        return ResponseEntity.ok(uuids);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UuidEntity>> getUuidById(@PathVariable Long id) {
        Optional<UuidEntity> uuidEntity = uuidService.getUuidById(id);
        return ResponseEntity.ok(uuidEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUuidById(@PathVariable Long id) {
        uuidService.deleteUuidById(id);
        return ResponseEntity.noContent().build();
    }
}
