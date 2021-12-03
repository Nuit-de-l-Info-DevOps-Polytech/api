package com.example.demo.controller;

import com.example.demo.model.entity.*;
import com.example.demo.model.entity.ids.ContenirEntityId;
import com.example.demo.model.entity.ids.SauverEntityId;
import com.example.demo.model.repository.*;
import io.swagger.models.auth.In;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/session_token")

public class SessionTokenController
{
    @Autowired
    private SessionTokenRepository sessionTokenRepository;

    @Autowired
    private PersonneRepository personneRepository;

    @GetMapping("")
    public ResponseEntity<List<SessionTokenEntity>> getAllSessionToken()
    {
        return ResponseEntity.ok(sessionTokenRepository.findAll());
    }

    @GetMapping("getAllById/{id}")
    public ResponseEntity<List<SessionTokenEntity>> getAllById(@PathVariable Integer userId)
    {
        var p = personneRepository.findById(userId);
        if ( p.isEmpty() )
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sessionTokenRepository.findAllByPersonneEntity(p.get()));
    }

    @GetMapping("getSessionTokenById/{id}")
    public ResponseEntity<SessionTokenEntity> getSessionTokenById(@PathVariable Integer id)
    {
        return ResponseEntity.of(sessionTokenRepository.findById(id));
    }

    @PostMapping("createSessionToken")
    public ResponseEntity<SessionTokenEntity> createSessionToken(@RequestBody SessionTokenEntity sessionToken)
    {
        return ResponseEntity.ok(sessionTokenRepository.save(sessionToken));
    }

    @PostMapping("createSessionTokenWithUserId/{idUser}")
    public ResponseEntity<SessionTokenEntity> createSessionTokenWithUserId(@PathVariable Integer idUser, @RequestBody String sessionToken)
    {
        var p = personneRepository.findById(idUser);
        if ( p.isEmpty() )
            return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(sessionTokenRepository.save(new SessionTokenEntity(0, p.get(), sessionToken)));
    }

    @DeleteMapping("deleteSessionTokenById/{id}")
    public ResponseEntity<Void> deleteSessionTokenById(@PathVariable Integer id)
    {
        if ( !sessionTokenRepository.existsById(id))
            ResponseEntity.notFound().build();
        sessionTokenRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("updateSessionTokenById/{id}")
    public ResponseEntity<SessionTokenEntity> updateSessionTokenById(@PathVariable Integer id, @RequestBody SessionTokenEntity sessionTokenEntity)
    {
        if ( !sessionTokenRepository.existsById(id))
            return ResponseEntity.notFound().build();
        sessionTokenEntity.setId(id);
        return ResponseEntity.ok(sessionTokenRepository.save(sessionTokenEntity));
    }

}


