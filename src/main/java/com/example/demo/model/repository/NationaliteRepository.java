package com.example.demo.model.repository;

import com.example.demo.model.entity.NationaliteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NationaliteRepository extends JpaRepository<NationaliteEntity, Integer>, JpaSpecificationExecutor<NationaliteEntity>
{

}
