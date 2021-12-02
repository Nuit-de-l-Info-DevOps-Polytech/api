package com.example.demo.controller.NationaliteController;

import com.example.demo.model.entity.BateauEntity;
import com.example.demo.model.entity.NationaliteEntity;
import com.example.demo.model.entity.NaufrageeEntity;
import com.example.demo.model.repository.BateauRepository;
import com.example.demo.model.repository.NationaliteRepository;
import com.example.demo.model.repository.NaufrageeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bateau")

public class BateauController
{
    @Autowired
    private BateauRepository bateauRepository;

    @GetMapping("")
    public ResponseEntity<List<BateauEntity>> getAllBateau()
    {
        return ResponseEntity.ok(bateauRepository.findAll());
    }

    @GetMapping("getNaufrageeById/{id}")
    public ResponseEntity<BateauEntity> getBateauById(@PathVariable Integer id)
    {
        return ResponseEntity.of(bateauRepository.findById(id));
    }

    @PostMapping("createNaufragee")
    public ResponseEntity<BateauEntity> createBateau(@RequestBody BateauEntity bateauEntity)
    {
        return ResponseEntity.ok(bateauRepository.save(bateauEntity));
    }

    @DeleteMapping("deleteBateauById/{id}")
    public ResponseEntity<Void> deleteBateauById(@PathVariable Integer id)
    {
        if ( !bateauRepository.existsById(id))
            ResponseEntity.notFound().build();
        bateauRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updateBateauById/{id}")
    public ResponseEntity<BateauEntity> updateNaufrageeById(@PathVariable Integer id, @RequestBody BateauEntity bateauEntity)
    {
        if ( !bateauRepository.existsById(id))
            return ResponseEntity.notFound().build();
        bateauEntity.setId(id);
        return ResponseEntity.ok(bateauRepository.save(bateauEntity));
    }

}


