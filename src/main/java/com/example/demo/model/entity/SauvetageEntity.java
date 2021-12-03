package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "sauvetage", schema = "public")
public class SauvetageEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_sauvetage", columnDefinition = "date" )
    private Date dateNauffrage;

    @Column(name = "titre", columnDefinition = "varchar(255)")
    private String titre;

    @Lob
    @Column(name = "description_sauvetage")
    private String descriptionSauvetage;

    @Lob
    @Column(name = "temoignages_sauvetage")
    private String temoignagesSauvetage;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "utilisateur_id", foreignKey = @ForeignKey(name = "fk_sauvetage_utilisateur_id"))
    private UtilisateurEntity utilisateurCreateur;

    @Lob
    @Column(name = "sources_sauvetage")
    private String sourcesSauvetage;

}
