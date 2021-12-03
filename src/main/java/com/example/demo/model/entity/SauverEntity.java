package com.example.demo.model.entity;

import com.example.demo.model.entity.ids.ConcernerEntityId;
import com.example.demo.model.entity.ids.SauverEntityId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sauver", schema = "public")
@IdClass(SauverEntityId.class)
public class SauverEntity
{
    @Id
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "sauvetage_id", foreignKey = @ForeignKey(name = "fk_sauver_sauvetage_id"))
    private SauvetageEntity sauvetage;

    @Id
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "naufragee_id", foreignKey = @ForeignKey(name = "fk_sauver_personne_id"))
    private NaufrageeEntity personne;


    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "etat_personne_id", foreignKey = @ForeignKey(name = "fk_sauver_etat_personne_id"))
    private EtatPersonneEntity etatPersonneEntity;

    @JsonIgnore
    public void setId(SauverEntityId id)
    {
        sauvetage = id.getSauvetage();
        personne = id.getPersonne();
    }

}