package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nationalitee", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = {"nationalitee"}, name = "udx_nationalitee_nationalitee"))
public class NationaliteEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nationalitee", columnDefinition = "varchar(255)")
    private String nationalitee;

}
