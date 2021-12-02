package com.example.demo.controller.NationaliteController;

import com.example.demo.model.entity.NationaliteEntity;
import com.example.demo.model.repository.NationaliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nationalite")
public class NationaliteController
{
    @Autowired
    private NationaliteRepository nationaliteRepository;

    @PostMapping("/createNationalite")
    public Integer createNationalite(@RequestBody String nom)
    {
        return nationaliteRepository.save(new NationaliteEntity(Integer.valueOf(0), nom)).getId();
    }
}
