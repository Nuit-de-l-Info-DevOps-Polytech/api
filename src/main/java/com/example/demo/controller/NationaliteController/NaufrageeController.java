package com.example.demo.controller.NationaliteController;

import com.example.demo.model.entity.NationaliteEntity;
import com.example.demo.model.entity.NaufrageeEntity;
import com.example.demo.model.repository.NationaliteRepository;
import com.example.demo.model.repository.NaufrageeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/naufragee")

public class NaufrageeController
{
    @Autowired
    private NaufrageeRepository naufrageeRepository;

    @GetMapping("")
    public ResponseEntity<List<NaufrageeEntity>> getAllNaufragee()
    {
        return ResponseEntity.ok(naufrageeRepository.findAll());
    }

    @GetMapping("getNaufrageeById/{id}")
    public ResponseEntity<NaufrageeEntity> getNaufrageeById(@PathVariable Integer id)
    {
        return ResponseEntity.of(naufrageeRepository.findById(id));
    }

    @PostMapping("createNaufragee")
    public ResponseEntity<NaufrageeEntity> createNaufragee(@RequestBody NaufrageeEntity naufrageeEntity)
    {
        return ResponseEntity.ok(naufrageeRepository.save(naufrageeEntity));
    }

    @DeleteMapping("deleteNaufrageeById/{id}")
    public ResponseEntity<Void> deleteNaufrageeById(@PathVariable Integer id)
    {
        if ( !naufrageeRepository.existsById(id))
            ResponseEntity.notFound().build();
        naufrageeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updateNaufrageeById/{id}")
    public ResponseEntity<NaufrageeEntity> updateNaufrageeById(@PathVariable Integer id, @RequestBody NaufrageeEntity naufrageeEntity)
    {
        if ( !naufrageeRepository.existsById(id))
            return ResponseEntity.notFound().build();
        naufrageeEntity.setId(id);
        return ResponseEntity.ok(naufrageeRepository.save(naufrageeEntity));
    }

}
