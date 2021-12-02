package com.example.demo.model.repository;

import com.example.demo.model.entity.NationaliteEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;
import java.util.Optional;

public interface NationaliteRepository extends JpaRepository<NationaliteEntity, Integer>, JpaSpecificationExecutor<NationaliteEntity>
{
    Optional<NationaliteEntity> findByNationalitee(String nationalitee);
    boolean existsByNationalitee(String nationalitee);

    @Transactional
    void deleteByNationalitee(String nationalitee);
}
