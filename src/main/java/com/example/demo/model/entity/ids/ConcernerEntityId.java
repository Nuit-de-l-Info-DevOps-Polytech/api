package com.example.demo.model.entity.ids;

import com.example.demo.model.entity.BateauEntity;
import com.example.demo.model.entity.SauvetageEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConcernerEntityId implements Serializable {
    private SauvetageEntity sauvetage;

    private BateauEntity bateau;


}