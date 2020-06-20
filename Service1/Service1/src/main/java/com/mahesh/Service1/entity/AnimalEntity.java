package com.mahesh.Service1.entity;

import com.mahesh.Service1.dto.AnimalDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Table(name = "animal")
@Getter
@Setter
@NoArgsConstructor
public class AnimalEntity {
    @Id
//    @GeneratedValue
    @Column(name = "id")
    int id;
    @Column(name = "parentid")
    int parentid;
    @Column(name = "name")
    String name;
    @Column(name = "color")
    String color;

    public AnimalDto toData(){
        AnimalDto animalDto = new AnimalDto(id, parentid, name, color);
        return animalDto;
    }
}
