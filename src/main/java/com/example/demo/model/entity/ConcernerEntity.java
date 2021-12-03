package com.example.demo.model.entity;

import com.example.demo.model.entity.ids.ConcernerEntityId;
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
@Table(name = "concerner", schema = "public")
@IdClass(ConcernerEntityId.class)
public class ConcernerEntity
{
    @Id
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "sauvetage_id", foreignKey = @ForeignKey(name = "fk_concerner_sauvetage_id"))
    private SauvetageEntity sauvetage;

    @Id
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "bateau_id", foreignKey = @ForeignKey(name = "fk_concerner_bateau_id"))
    private BateauEntity bateau;


    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "etat_bateau_id", foreignKey = @ForeignKey(name = "fk_concerner_etat_bateau_id"))
    private EtatBateauEntity etatBateauEntity;

    @JsonIgnore
    public void setId(ConcernerEntityId id)
    {
        sauvetage = id.getSauvetage();
        bateau = id.getBateau();
    }

}