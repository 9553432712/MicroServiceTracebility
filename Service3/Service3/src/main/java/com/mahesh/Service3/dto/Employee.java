package com.mahesh.Service3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    String name;
    String surname;

    public String toString(){
        return name +" "+surname;
    }
}
