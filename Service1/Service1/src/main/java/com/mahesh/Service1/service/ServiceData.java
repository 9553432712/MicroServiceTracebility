package com.mahesh.Service1.service;

import com.mahesh.Service1.dto.AnimalDto;
import com.mahesh.Service1.entity.AnimalEntity;
import com.mahesh.Service1.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceData {

    @Autowired
    AnimalRepository animalRepository;

    public AnimalDto create(AnimalDto animalDto){
        AnimalEntity animalEntity = animalRepository.save(animalDto.toData());
        return animalEntity.toData();
    }

    public List<AnimalDto> getAll() {
        List<AnimalEntity> animalEntityList = animalRepository.findAll();
        List<AnimalDto> animalDtoList = animalEntityList.stream().map(animalEntity -> animalEntity.toData()).collect(Collectors.toList());
        return animalDtoList;
    }

    public AnimalDto get(int id) {
        Optional<AnimalEntity> animalEntity = animalRepository.findById(id);
        return animalEntity.get().toData();
    }

    public AnimalDto edit(AnimalDto animalDto) {
        AnimalEntity animalEntity = animalRepository.save(animalDto.toData());
        return animalEntity.toData();
    }

    public void delete(int id) {
        animalRepository.deleteById(id);
    }
}
