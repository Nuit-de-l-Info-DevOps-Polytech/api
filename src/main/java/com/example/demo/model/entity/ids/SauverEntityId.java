package com.example.demo.model.entity.ids;

import com.example.demo.model.entity.PersonneEntity;
import com.example.demo.model.entity.SauvetageEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SauverEntityId implements Serializable {
    private SauvetageEntity sauvetage;

    private PersonneEntity personne;


}