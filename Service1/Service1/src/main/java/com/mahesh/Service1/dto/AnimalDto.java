package com.mahesh.Service1.dto;

import com.mahesh.Service1.entity.AnimalEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDto implements Serializable {
    int id;
    int parentid;
    String name;
    String color;

    public AnimalEntity toData(){
        AnimalEntity animalEntity = new AnimalEntity(id, parentid, name, color);
        return animalEntity;
    }
}
