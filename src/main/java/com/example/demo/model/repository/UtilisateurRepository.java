package com.example.demo.model.repository;

import com.example.demo.model.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;
import java.util.Optional;


public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer>, JpaSpecificationExecutor<UtilisateurEntity>
{
    boolean existsByMail(String mail);
    Optional<UtilisateurEntity> findByMail(String mail);

    @Transactional
    void deleteByMail(String mail);
}