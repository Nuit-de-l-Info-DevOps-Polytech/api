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
@Table(name = "utilisateur", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = {"mail"}, name = "udx_utilisateur_mail"))
public class UtilisateurEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", columnDefinition = "varchar(255)")
    private String nom;

    @Column(name = "prenom", columnDefinition = "varchar(255)")
    private String prenom;

    @Column(name = "mail", columnDefinition = "varchar(255)")
    private String mail;

    @Column(name = "pseudo", columnDefinition = "varchar(255)")
    private String pseudo;

    @Column(name = "lieu_naissance", columnDefinition = "varchar(255)")
    private String lieuNaissance;

    @Column(name = "hash_mdp", columnDefinition = "text")
    private String password;

    @Column(name = "session_token", columnDefinition = "text")
    private String sessionToken;

    @Column(name = "refresh_token", columnDefinition = "text")
    private String refreshToken;

    @Column(name = "is_admin", columnDefinition = "boolean default false")
    private Boolean isAdmin;
}
