package com.example.demo.model.entity.ids;

import com.example.demo.model.entity.BateauEntity;
import com.example.demo.model.entity.SauvetageEntity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ConcernerEntityId implements Serializable {
    private SauvetageEntity sauvetage;

    private BateauEntity bateau;


}