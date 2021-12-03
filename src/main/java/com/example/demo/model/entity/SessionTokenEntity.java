package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "session_token", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = {"session_token"}, name = "udx_session_token_ssesion_token"))
public class SessionTokenEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "personne_id", foreignKey = @ForeignKey(name = "fk_session_token_personne_id"))
    private PersonneEntity personneEntity;

    @Column(name = "session_token", columnDefinition = "text")
    private String sessionToken;


}
