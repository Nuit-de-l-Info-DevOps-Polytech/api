package com.example.demo.controller.NationaliteController;

import com.example.demo.model.entity.NationaliteEntity;
import com.example.demo.model.repository.NationaliteRepository;
import com.example.demo.model.repository.NaufrageeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/naufragee")

public class NaufrageeController
{
    @Autowired
    private NaufrageeRepository naufrageeRepository;


}
