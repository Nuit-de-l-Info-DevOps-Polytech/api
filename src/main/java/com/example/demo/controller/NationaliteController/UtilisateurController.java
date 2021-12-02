package com.example.demo.controller.NationaliteController;

import com.example.demo.model.entity.NationaliteEntity;
import com.example.demo.model.entity.UtilisateurEntity;
import com.example.demo.model.repository.NationaliteRepository;
import com.example.demo.model.repository.UtilisateurRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController
{
    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @GetMapping("getUtilisateurById/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
    })
    public ResponseEntity<UtilisateurEntity> getUtilisateurById(@PathVariable Integer id)
    {
        return ResponseEntity.of(utilisateurRepository.findById(id));
    }

    @GetMapping("getUtilisateurByMail/{mail}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
    })
    public ResponseEntity<UtilisateurEntity> getUtilisateurByMail(@PathVariable String mail)
    {
        return ResponseEntity.of(utilisateurRepository.findByMail(mail));
    }

    @PutMapping("updateUtilisateurById/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "L'utilisateur n'existe pas")
    })
    public ResponseEntity<UtilisateurEntity> updateUtilisateurById(@PathVariable Integer id, @RequestBody UtilisateurEntity utilisateurEntity)
    {
        if ( !utilisateurRepository.existsById(id) )
            return ResponseEntity.notFound().build();

        utilisateurEntity.setId(id);
        return ResponseEntity.ok(utilisateurRepository.save(utilisateurEntity));
    }

    @PutMapping("updateUtilisateurByMail/{mail}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "L'utilisateur n'existe pas")
    })
    public ResponseEntity<UtilisateurEntity> updateUtilisateurByMail(@PathVariable String mail, @RequestBody UtilisateurEntity utilisateurEntity)
    {
        if ( !utilisateurRepository.existsByMail(mail) )
            return ResponseEntity.notFound().build();

        utilisateurEntity.setMail(mail);
        utilisateurEntity.setId(utilisateurRepository.findByMail(mail).get().getId());

        return ResponseEntity.ok(utilisateurRepository.save(utilisateurEntity));
    }

    @DeleteMapping("deleteUtilisateurById/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "L'utilisateur n'existe pas")
    })
    public ResponseEntity<Void> deleteUtilisateurById(@PathVariable Integer id)
    {
        if ( !utilisateurRepository.existsById(id) )
            return ResponseEntity.notFound().build();

        utilisateurRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("deleteUtilisateurByMail/{mail}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "L'utilisateur n'existe pas")
    })
    public ResponseEntity<Void> deleteUtilisateurByMail(@PathVariable String mail)
    {
        if ( !utilisateurRepository.existsByMail(mail) )
            return ResponseEntity.notFound().build();

        utilisateurRepository.deleteByMail(mail);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("createUtilisateur")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 409, message = "Un utilisateur avec le même mail existe déjà")
    })
    public ResponseEntity<UtilisateurEntity> createUtilisateur(@RequestBody UtilisateurEntity utilisateurEntity)
    {
        if ( utilisateurRepository.existsByMail(utilisateurEntity.getMail()))
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        return ResponseEntity.ok(utilisateurRepository.save(utilisateurEntity));
    }
}
