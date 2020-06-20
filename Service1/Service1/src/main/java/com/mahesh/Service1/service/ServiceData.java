package com.mahesh.Service1.service;

import com.mahesh.Service1.dto.AnimalDto;
import com.mahesh.Service1.dto.SubAnimalDto;
import com.mahesh.Service1.entity.AnimalEntity;
import com.mahesh.Service1.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

    public Map formatData() {
        List<AnimalEntity> animalEntityList = animalRepository.findAll();
        List<AnimalDto> animalDtoList = animalEntityList.stream().map(animalEntity -> animalEntity.toData()).collect(Collectors.toList());
        return formatData(animalDtoList);
    }

    private Map formatData(List<AnimalDto> animalDtoList){
        Map<String, List<SubAnimalDto>> m = new HashMap();
        AnimalDto animalDto = null;
        int parentId;
        String name;
        for(int i=0;i<animalDtoList.size();i++){
            animalDto = animalDtoList.get(i);
             parentId = animalDto.getParentid();
             name = getNameByparentId(parentId, animalDtoList);
            if(m.containsKey(name)){
                List<SubAnimalDto> l = m.get(name);
                l.add(new SubAnimalDto(animalDtoList.get(i).getName()));
                if(!name.equals("")) {
                    m.put(name, l);
                }
            }else {
                List<SubAnimalDto> l = new ArrayList<>();
                l.add(new SubAnimalDto(animalDtoList.get(i).getName()));
                if(!name.equals("")) {
                    m.put(name, l);
                }
            }
        }
        System.out.println(m);
        return m;
    }
    private static String getNameByparentId(int parent, List<AnimalDto> animalDtoList) {
        for(int i=0;i<animalDtoList.size();i++){
            if(animalDtoList.get(i).getId()==parent){
                return animalDtoList.get(i).getName();
            }
        }
        return "";
    }
}
