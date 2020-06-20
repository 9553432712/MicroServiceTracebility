package com.mahesh.Service1.controller;

import com.mahesh.Service1.dto.AnimalDto;
import com.mahesh.Service1.service.ServiceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DataController {

    @Autowired
    ServiceData serviceData;

    @PostMapping("/create")
    public AnimalDto create(@RequestBody AnimalDto animalDto){
        return serviceData.create(animalDto);
    }

    @GetMapping("/get/{id}")
    public AnimalDto create(@PathVariable("id") int id){
        return serviceData.get(id);
    }

    @GetMapping("/get-db-data")
    public List<AnimalDto> getAll(){
        return serviceData.getAll();
    }

    @GetMapping("/get")
    public Map formatData(){
        return serviceData.formatData();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        serviceData.delete(id);
    }

    @PutMapping("/edit")
    public AnimalDto edit(@RequestBody AnimalDto animalDto){
        return serviceData.edit(animalDto);
    }


}
