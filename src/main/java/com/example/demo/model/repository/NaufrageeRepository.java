package com.example.demo.model.repository;

import com.example.demo.model.entity.NaufrageeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface NaufrageeRepository extends JpaRepository<NaufrageeEntity, Integer>, JpaSpecificationExecutor<NaufrageeEntity>
{
}