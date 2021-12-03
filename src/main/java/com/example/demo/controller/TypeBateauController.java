package com.example.demo.controller;

import com.example.demo.model.entity.NationaliteEntity;
import com.example.demo.model.entity.TypeBateauEntity;
import com.example.demo.model.repository.NationaliteRepository;
import com.example.demo.model.repository.TypeBateauRepository;
import io.swagger.models.Response;
import org.apache.tomcat.util.buf.UriUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type_bateau")
public class TypeBateauController
{
    @Autowired
    private TypeBateauRepository typeBateauRepository;

    @GetMapping("")
    public ResponseEntity<List<TypeBateauEntity>> getAllNationality()
    {
        return ResponseEntity.ok(typeBateauRepository.findAll());
    }

    @GetMapping("getTypeBateauById/{id}")
    public ResponseEntity<TypeBateauEntity> getTypeBateauById(@PathVariable Integer id)
    {
        return ResponseEntity.of(typeBateauRepository.findById(id));
    }

    @GetMapping("getTypeBateauByType/{type}")
    public ResponseEntity<TypeBateauEntity> getTypeBateauByType(@PathVariable String type)
    {
        return ResponseEntity.of(typeBateauRepository.findByType(type));
    }

    @DeleteMapping("deleteTypeBateauById/{id}")
    public ResponseEntity<Void> deleteTypeBateauById(@PathVariable Integer id)
    {
        if ( !typeBateauRepository.existsById(id) )
            return ResponseEntity.notFound().build();
        typeBateauRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("deleteTypeBateauByType/{type}")
    public ResponseEntity<Void> deleteTypeBateauByType(@PathVariable String type)
    {
        if ( !typeBateauRepository.existsByType(type) )
            return ResponseEntity.notFound().build();
        typeBateauRepository.deleteByType(type);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("createTypeBateau")
    public ResponseEntity<TypeBateauEntity> createTypeBateau(@RequestBody TypeBateauEntity typeBateauEntity)
    {
        return ResponseEntity.ok(typeBateauRepository.save(typeBateauEntity));
    }

    @PutMapping("updateTypeBateauById/{id}/")
    public ResponseEntity<TypeBateauEntity> updateTypeBateauById(@PathVariable Integer id, @RequestBody String type)
    {
        if ( !typeBateauRepository.existsById(id))
            return ResponseEntity.notFound().build();
        if (typeBateauRepository.existsByType(type))
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        return ResponseEntity.ok(typeBateauRepository.save(new TypeBateauEntity(id, type)));
    }
}
