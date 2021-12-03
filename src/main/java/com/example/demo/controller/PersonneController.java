package com.example.demo.controller;

import com.example.demo.model.entity.PersonneEntity;
import com.example.demo.model.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personne")

public class PersonneController
{
    @Autowired
    private PersonneRepository personneRepository;

    @GetMapping("")
    public ResponseEntity<List<PersonneEntity>> getAllPersonne()
    {
        return ResponseEntity.ok(personneRepository.findAll());
    }

    @GetMapping("getPersonneById/{id}")
    public ResponseEntity<PersonneEntity> getPersonneById(@PathVariable Integer id)
    {
        return ResponseEntity.of(personneRepository.findById(id));
    }

    @PostMapping("createPersonne")
    public ResponseEntity<PersonneEntity> createPersonne(@RequestBody PersonneEntity personneEntity)
    {
        return ResponseEntity.ok(personneRepository.save(personneEntity));
    }

    @DeleteMapping("deletePersonneById/{id}")
    public ResponseEntity<Void> deletePersonneById(@PathVariable Integer id)
    {
        if ( !personneRepository.existsById(id))
            ResponseEntity.notFound().build();
        personneRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updatePersonneById/{id}")
    public ResponseEntity<PersonneEntity> updatePersonneById(@PathVariable Integer id, @RequestBody PersonneEntity personneEntity)
    {
        if ( !personneRepository.existsById(id))
            return ResponseEntity.notFound().build();
        personneEntity.setId(id);
        return ResponseEntity.ok(personneRepository.save(personneEntity));
    }

}
