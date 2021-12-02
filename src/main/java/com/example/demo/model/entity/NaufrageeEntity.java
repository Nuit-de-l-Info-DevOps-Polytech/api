package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "naufragee", schema = "public")
public class NaufrageeEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", columnDefinition = "varchar(255)")
    private String nom;

    @Column(name = "prenom", columnDefinition = "varchar(255)")
    private String prenom;

    @Column(name = "lieu_naissance", columnDefinition = "varchar(255)")
    private String lieuNaissance;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "nationalitee_id", foreignKey = @ForeignKey(name = "fk_naufragee_nationalitee_id"))
    private NationaliteEntity nationaliteEntity;

    @Column(name = "profession", columnDefinition = "varchar(255)")
    private String profession;

    @Column(name = "date_naissance", columnDefinition = "date" )
    private Date dateNaissance;

    @Column(name = "date_deces", columnDefinition = "date" )
    private Date dateDeces;

    @Column(name = "mail", columnDefinition = "varchar(255)" )
    private String mail;

    @Column(name = "tel", columnDefinition = "varchar(255)" )
    private String tel;

    @Column(name = "photo", columnDefinition = "text" )
    private String photo;

    @Column(name = "source", columnDefinition = "text" )
    private String source;

}
