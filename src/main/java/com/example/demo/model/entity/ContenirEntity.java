package com.example.demo.model.entity;

import com.example.demo.model.entity.ids.ContenirEntityId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contenir", schema = "public")
@IdClass(ContenirEntityId.class)
public class ContenirEntity
{
    @Id
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "bateau_id", foreignKey = @ForeignKey(name = "fk_contenir_bateau_id"))
    private BateauEntity bateau;

    @Id
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "personne_id", foreignKey = @ForeignKey(name = "fk_contenir_personne_id"))
    private PersonneEntity personne;


    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "etat_personne_id", foreignKey = @ForeignKey(name = "fk_contenir_etat_personne_id"))
    private EtatPersonneEntity etatPersonneEntity;

    @JsonIgnore
    public void setId(ContenirEntityId id)
    {
        bateau = id.getBateau();
        personne = id.getPersonne();
    }

}