package com.example.demo.controller;

import com.example.demo.model.entity.SauvetageEntity;
import com.example.demo.model.repository.SauvetageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sauvetage")

public class SauvetageController
{
    @Autowired
    private SauvetageRepository sauvetageRepository;

    @GetMapping("")
    public ResponseEntity<List<SauvetageEntity>> getAllSauvetage()
    {
        return ResponseEntity.ok(sauvetageRepository.findAll());
    }

    @GetMapping("getSauvetageById/{id}")
    public ResponseEntity<SauvetageEntity> getSauvetageById(@PathVariable Integer id)
    {
        return ResponseEntity.of(sauvetageRepository.findById(id));
    }

    @PostMapping("createSauvetage")
    public ResponseEntity<SauvetageEntity> createSauvetage(@RequestBody SauvetageEntity sauvetageEntity)
    {
        return ResponseEntity.ok(sauvetageRepository.save(sauvetageEntity));
    }

    @DeleteMapping("deleteSauvetageById/{id}")
    public ResponseEntity<Void> deleteSauvetageById(@PathVariable Integer id)
    {
        if ( !sauvetageRepository.existsById(id))
            ResponseEntity.notFound().build();
        sauvetageRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updateSauvetageById/{id}")
    public ResponseEntity<SauvetageEntity> updateSauvetageById(@PathVariable Integer id, @RequestBody SauvetageEntity sauvetageEntity)
    {
        if ( !sauvetageRepository.existsById(id))
            return ResponseEntity.notFound().build();
        sauvetageEntity.setId(id);
        return ResponseEntity.ok(sauvetageRepository.save(sauvetageEntity));
    }

}


