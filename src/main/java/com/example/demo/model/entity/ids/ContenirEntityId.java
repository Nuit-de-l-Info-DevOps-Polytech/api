package com.example.demo.model.entity.ids;

import com.example.demo.model.entity.BateauEntity;
import com.example.demo.model.entity.NaufrageeEntity;
import com.example.demo.model.entity.SauvetageEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ContenirEntityId implements Serializable
{
    private NaufrageeEntity personne;
    private BateauEntity bateau;

}