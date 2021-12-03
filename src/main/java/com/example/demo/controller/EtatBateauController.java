package com.example.demo.controller;

import com.example.demo.model.entity.EtatBateauEntity;
import com.example.demo.model.repository.EtatBateauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etatBateau")

public class EtatBateauController
{
    @Autowired
    private EtatBateauRepository etatBateauRepository;

    @GetMapping("")
    public ResponseEntity<List<EtatBateauEntity>> getAllEtatBateau()
    {
        return ResponseEntity.ok(etatBateauRepository.findAll());
    }

    @GetMapping("getEtatBateauById/{id}")
    public ResponseEntity<EtatBateauEntity> getEtatBateauById(@PathVariable Integer id)
    {
        return ResponseEntity.of(etatBateauRepository.findById(id));
    }

    @PostMapping("createEtatBateau")
    public ResponseEntity<EtatBateauEntity> createEtatBateau(@RequestBody EtatBateauEntity etatBateauEntity)
    {
        return ResponseEntity.ok(etatBateauRepository.save(etatBateauEntity));
    }

    @DeleteMapping("deleteEtatBateauById/{id}")
    public ResponseEntity<Void> deleteEtatBateauById(@PathVariable Integer id)
    {
        if ( !etatBateauRepository.existsById(id))
            ResponseEntity.notFound().build();
        etatBateauRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updateEtatBateauById/{id}")
    public ResponseEntity<EtatBateauEntity> updateEtatBateauById(@PathVariable Integer id, @RequestBody EtatBateauEntity etatBateauEntity)
    {
        if ( !etatBateauRepository.existsById(id))
            return ResponseEntity.notFound().build();
        etatBateauEntity.setId(id);
        return ResponseEntity.ok(etatBateauRepository.save(etatBateauEntity));
    }

}
