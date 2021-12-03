package com.example.demo.model.repository;

import com.example.demo.model.entity.PersonneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface PersonneRepository extends JpaRepository<PersonneEntity, Integer>, JpaSpecificationExecutor<PersonneEntity>
{
}