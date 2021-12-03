package com.example.demo.model.repository;

import com.example.demo.model.entity.NationaliteEntity;
import com.example.demo.model.entity.TypeBateauEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;
import java.util.Optional;

public interface TypeBateauRepository extends JpaRepository<TypeBateauEntity, Integer>, JpaSpecificationExecutor<TypeBateauEntity>
{
    Optional<TypeBateauEntity> findByType(String type);
    boolean existsByType(String type);

    @Transactional
    void deleteByType(String type);
}
