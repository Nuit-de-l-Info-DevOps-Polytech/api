package com.example.demo.controller;

import com.example.demo.model.entity.*;
import com.example.demo.model.entity.ids.ContenirEntityId;
import com.example.demo.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenir")

public class ContenirController
{
    @Autowired
    private ContenirRepository contenirRepository;

    @GetMapping("")
    public ResponseEntity<List<ContenirEntity>> getAllContenir()
    {
        return ResponseEntity.ok(contenirRepository.findAll());
    }

    @GetMapping("getContenirById/{id}")
    public ResponseEntity<ContenirEntity> getContenirById(@PathVariable ContenirEntityId id)
    {
        return ResponseEntity.of(contenirRepository.findById(id));
    }

    @PostMapping("createContenir")
    public ResponseEntity<ContenirEntity> createContenir(@RequestBody ContenirEntity contenirEntity)
    {
        return ResponseEntity.ok(contenirRepository.save(contenirEntity));
    }

    @DeleteMapping("deleteContenirById/{id}")
    public ResponseEntity<Void> deleteContenirById(@PathVariable ContenirEntityId id)
    {
        if ( !contenirRepository.existsById(id))
            ResponseEntity.notFound().build();
        contenirRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updateContenirById/{id}")
    public ResponseEntity<ContenirEntity> updateContenirById(@PathVariable ContenirEntityId id, @RequestBody ContenirEntity contenirEntity)
    {
        if ( !contenirRepository.existsById(id))
            return ResponseEntity.notFound().build();
        contenirEntity.setId(id);
        return ResponseEntity.ok(contenirRepository.save(contenirEntity));
    }

}


