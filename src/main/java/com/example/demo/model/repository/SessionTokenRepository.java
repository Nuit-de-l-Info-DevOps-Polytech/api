package com.example.demo.model.repository;

import com.example.demo.model.entity.*;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SessionTokenRepository extends JpaRepository<SessionTokenEntity, Integer>, JpaSpecificationExecutor<SessionTokenEntity>
{
    List<SessionTokenEntity> findALlByUtilisateurEntity(UtilisateurEntity utilisateurEntity);
    boolean existsBySessionToken(String sessionToken);

    @Transactional
    void deleteBySessionToken(String sessionToken);
}
