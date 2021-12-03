package com.example.demo.controller;

import com.example.demo.model.entity.*;
import com.example.demo.model.entity.ids.ContenirEntityId;
import com.example.demo.model.entity.ids.SauverEntityId;
import com.example.demo.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sauver")

public class SauverController
{
    @Autowired
    private SauverRepository sauverRepository;

    @GetMapping("")
    public ResponseEntity<List<SauverEntity>> getAllSauver()
    {
        return ResponseEntity.ok(sauverRepository.findAll());
    }

    @GetMapping("getSauverById/{id}")
    public ResponseEntity<SauverEntity> getSauverById(@PathVariable SauverEntityId id)
    {
        return ResponseEntity.of(sauverRepository.findById(id));
    }

    @PostMapping("createSauver")
    public ResponseEntity<SauverEntity> createSauver(@RequestBody SauverEntity sauverEntity)
    {
        return ResponseEntity.ok(sauverRepository.save(sauverEntity));
    }

    @DeleteMapping("deleteSauverById/{id}")
    public ResponseEntity<Void> deleteSauverById(@PathVariable SauverEntityId id)
    {
        if ( !sauverRepository.existsById(id))
            ResponseEntity.notFound().build();
        sauverRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updateSauverById/{id}")
    public ResponseEntity<SauverEntity> updateSauverById(@PathVariable SauverEntityId id, @RequestBody SauverEntity sauverEntity)
    {
        if ( !sauverRepository.existsById(id))
            return ResponseEntity.notFound().build();
        sauverEntity.setId(id);
        return ResponseEntity.ok(sauverRepository.save(sauverEntity));
    }

}


