package com.example.demo.model.repository;

import com.example.demo.model.entity.BateauEntity;
import com.example.demo.model.entity.NationaliteEntity;
import com.example.demo.model.entity.SauvetageEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;
import java.util.Optional;

public interface SauvetageRepository extends JpaRepository<SauvetageEntity, Integer>, JpaSpecificationExecutor<SauvetageEntity>
{
}
