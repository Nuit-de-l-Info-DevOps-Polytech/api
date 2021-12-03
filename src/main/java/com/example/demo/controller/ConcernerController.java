package com.example.demo.controller;

import com.example.demo.model.entity.ConcernerEntity;
import com.example.demo.model.entity.ids.ConcernerEntityId;
import com.example.demo.model.repository.ConcernerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concerner")

public class ConcernerController
{
    @Autowired
    private ConcernerRepository concernerRepository;

    @GetMapping("")
    public ResponseEntity<List<ConcernerEntity>> getAllConcerner()
    {
        return ResponseEntity.ok(concernerRepository.findAll());
    }

    @GetMapping("getConcernerById/{id}")
    public ResponseEntity<ConcernerEntity> getConcernerById(@PathVariable ConcernerEntityId id)
    {
        return ResponseEntity.of(concernerRepository.findById(id));
    }

    @PostMapping("createConcerner")
    public ResponseEntity<ConcernerEntity> createConcerner(@RequestBody ConcernerEntity concernerEntity)
    {
        return ResponseEntity.ok(concernerRepository.save(concernerEntity));
    }

    @DeleteMapping("deleteConcernerById/{id}")
    public ResponseEntity<Void> deleteConcernerById(@PathVariable ConcernerEntityId id)
    {
        if ( !concernerRepository.existsById(id))
            ResponseEntity.notFound().build();
        concernerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updateConcerncerById/{id}")
    public ResponseEntity<ConcernerEntity> updateConcerncerById(@PathVariable ConcernerEntityId id, @RequestBody ConcernerEntity concernerEntity)
    {
        if ( !concernerRepository.existsById(id))
            return ResponseEntity.notFound().build();
        concernerEntity.setId(id);
        return ResponseEntity.ok(concernerRepository.save(concernerEntity));
    }

}


