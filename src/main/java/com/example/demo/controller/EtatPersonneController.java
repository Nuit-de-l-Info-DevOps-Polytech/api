package com.example.demo.controller;

import com.example.demo.model.entity.EtatBateauEntity;
import com.example.demo.model.entity.EtatPersonneEntity;
import com.example.demo.model.entity.NationaliteEntity;
import com.example.demo.model.entity.NaufrageeEntity;
import com.example.demo.model.repository.EtatBateauRepository;
import com.example.demo.model.repository.EtatPersonneRepository;
import com.example.demo.model.repository.NationaliteRepository;
import com.example.demo.model.repository.NaufrageeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etatPersonne")

public class EtatPersonneController
{
    @Autowired
    private EtatPersonneRepository etatPersonneRepository;

    @GetMapping("")
    public ResponseEntity<List<EtatPersonneEntity>> getAllEtatPersonne()
    {
        return ResponseEntity.ok(etatPersonneRepository.findAll());
    }

    @GetMapping("getEtatPersonneById/{id}")
    public ResponseEntity<EtatPersonneEntity> getEtatPersonneById(@PathVariable Integer id)
    {
        return ResponseEntity.of(etatPersonneRepository.findById(id));
    }

    @PostMapping("createEtatPersonne")
    public ResponseEntity<EtatPersonneEntity> createEtatPersonne(@RequestBody EtatPersonneEntity etatPersonneEntity)
    {
        return ResponseEntity.ok(etatPersonneRepository.save(etatPersonneEntity));
    }

    @DeleteMapping("deleteEtatPersonneById/{id}")
    public ResponseEntity<Void> deleteEtatPersonneById(@PathVariable Integer id)
    {
        if ( !etatPersonneRepository.existsById(id))
            ResponseEntity.notFound().build();
        etatPersonneRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updateEtatPersonneById/{id}")
    public ResponseEntity<EtatPersonneEntity> updateEtatPersonneById(@PathVariable Integer id, @RequestBody EtatPersonneEntity etatPersonneEntity)
    {
        if ( !etatPersonneRepository.existsById(id))
            return ResponseEntity.notFound().build();
        etatPersonneEntity.setId(id);
        return ResponseEntity.ok(etatPersonneRepository.save(etatPersonneEntity));
    }

}
