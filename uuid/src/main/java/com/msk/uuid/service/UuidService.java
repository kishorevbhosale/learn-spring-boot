package com.msk.uuid.service;

import com.msk.uuid.model.UuidEntity;
import com.msk.uuid.repo.UuidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UuidService {
    @Autowired
    private UuidRepository uuidRepository;

    public UuidEntity generateAndSaveUuid() {
        UuidEntity uuidEntity = new UuidEntity();
        uuidEntity.setUuid(UUID.randomUUID());
        return uuidRepository.save(uuidEntity);
    }

    public List<UuidEntity> getAllUuids(){
        return uuidRepository.findAll();
    }

    public Optional<UuidEntity> getUuidById(Long id){
        return uuidRepository.findById(id);
    }

    public void deleteUuidById(Long id) {
        uuidRepository.deleteById(id);
    }
}
