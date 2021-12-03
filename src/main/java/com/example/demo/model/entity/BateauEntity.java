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
@Table(name = "bateau", schema = "public")
public class BateauEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", columnDefinition = "varchar(255)")
    private String nom;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "type_bateau_id", foreignKey = @ForeignKey(name = "fk_bateau_type_bateau_id"))
    private TypeBateauEntity type;

    @Column(name = "date_nauffrage", columnDefinition = "date" )
    private Date dateNauffrage;

    @Column(name = "photo_url", columnDefinition = "text")
    private String photo;

    @Column(name = "sources_bateau", columnDefinition = "text")
    private String sources;

}
