package com.example.demo.controller.NationaliteController;

import com.example.demo.model.entity.NationaliteEntity;
import com.example.demo.model.repository.NationaliteRepository;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nationalite")
public class NationaliteController
{
    @Autowired
    private NationaliteRepository nationaliteRepository;

    @GetMapping("")
    public ResponseEntity<List<NationaliteEntity>> getAllNationality()
    {
        return ResponseEntity.ok(nationaliteRepository.findAll());
    }

    @GetMapping("getNationaliteeById/{id}")
    public ResponseEntity<NationaliteEntity> getNationaliteeById(@PathVariable Integer id)
    {
        return ResponseEntity.of(nationaliteRepository.findById(id));
    }

    @GetMapping("getNationaliteeByName/{name}")
    public ResponseEntity<NationaliteEntity> getNationaliteeByName(@PathVariable String name)
    {
        return ResponseEntity.of(nationaliteRepository.findByNationalitee(name));
    }

    @DeleteMapping("deleteNationaliteeById/{id}")
    public ResponseEntity<Void> deleteNationaliteeById(@PathVariable Integer id)
    {
        if ( !nationaliteRepository.existsById(id) )
            return ResponseEntity.notFound().build();
        nationaliteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("deleteNationaliteeByName/{name}")
    public ResponseEntity<Void> deleteNationaliteeById(@PathVariable String name)
    {
        if ( !nationaliteRepository.existsByNationalitee(name) )
            return ResponseEntity.notFound().build();
        nationaliteRepository.deleteByNationalitee(name);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("createNationalitee")
    public ResponseEntity<NationaliteEntity> createNationalitee(@RequestBody NationaliteEntity nationaliteEntity)
    {
        return ResponseEntity.ok(nationaliteRepository.save(nationaliteEntity));
    }

    @PutMapping("updateNationaliteeById/{id}/")
    public ResponseEntity<NationaliteEntity> updateById(@PathVariable Integer id, @RequestBody String name)
    {
        if ( !nationaliteRepository.existsById(id))
            return ResponseEntity.notFound().build();
        if (nationaliteRepository.existsByNationalitee(name))
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        return ResponseEntity.ok(nationaliteRepository.save(new NationaliteEntity(id, name)));
    }
}
