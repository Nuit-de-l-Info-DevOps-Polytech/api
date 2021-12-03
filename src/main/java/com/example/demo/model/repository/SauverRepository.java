package com.example.demo.model.repository;

import com.example.demo.model.entity.*;
import com.example.demo.model.entity.ids.ConcernerEntityId;
import com.example.demo.model.entity.ids.ContenirEntityId;
import com.example.demo.model.entity.ids.SauverEntityId;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;
import java.util.Optional;

public interface SauverRepository extends JpaRepository<SauverEntity, SauverEntityId>, JpaSpecificationExecutor<SauverEntity>
{

}
