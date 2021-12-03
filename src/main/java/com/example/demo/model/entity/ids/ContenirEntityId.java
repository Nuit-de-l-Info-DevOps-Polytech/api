package com.example.demo.model.entity.ids;

import com.example.demo.model.entity.BateauEntity;
import com.example.demo.model.entity.PersonneEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ContenirEntityId implements Serializable
{
    private PersonneEntity personne;
    private BateauEntity bateau;

}