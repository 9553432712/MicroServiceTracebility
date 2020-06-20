package com.mahesh.Service1.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class SampleUtility {
    public static void main(String ar[]){
        List<AnimalDto> animalDtoList = new ArrayList();
        animalDtoList.add(new AnimalDto(1,	0,	"Warrior",	"red"));
        animalDtoList.add(new AnimalDto(2,	0,	"Wizard",	"green"));
        animalDtoList.add(new AnimalDto(3,	0,	"Priest",	"white"));
        animalDtoList.add(new AnimalDto(4,	0,	"Rogue",	"yellow"));
        animalDtoList.add(new AnimalDto(5,	1,	"Fighter",	"blue"));
        animalDtoList.add(new AnimalDto(6,	1,	"Paladin",	"lighblue"));
        animalDtoList.add(new AnimalDto(7,	1,	"Ranger",	"lighgreen"));
        animalDtoList.add(new AnimalDto(8,	2,	"Mage",	"grey"));
        animalDtoList.add(new AnimalDto(9,	2,	"Specialist wizard",	"lightgrey"));
        animalDtoList.add(new AnimalDto(10,	3,	"Cleric",	"red"));
        animalDtoList.add(new AnimalDto(11,	3,	"Druid",	"green"));
        animalDtoList.add(new AnimalDto(12,	3,	"Priest of specific mythos","white"));
        animalDtoList.add(new AnimalDto(13,	4,	"Thief",	"yellow"));
        animalDtoList.add(new AnimalDto(14,	4,	"Bard",	"blue"));
        animalDtoList.add(new AnimalDto(15,	13,	"Assassin",	"lighblue"));
        

        Map<String, List<SubAnimalDto>> m = new HashMap();
        AnimalDto animalDto = null;
        for(int i=0;i<animalDtoList.size();i++){
            animalDto = animalDtoList.get(i);
            int parent = animalDto.parentid;
            if(m.containsKey(getNameByparentId(parent, animalDtoList))){
                List<SubAnimalDto> l = m.get(getNameByparentId(parent, animalDtoList));
                l.add(new SubAnimalDto(animalDtoList.get(i).name));
                if(!getNameByparentId(parent, animalDtoList).equals("")) {
                    m.put(getNameByparentId(parent, animalDtoList), l);
                }
            }else {
                List<SubAnimalDto> l = new ArrayList<>();
                l.add(new SubAnimalDto(animalDtoList.get(i).name));
                if(!getNameByparentId(parent, animalDtoList).equals("")) {
                    m.put(getNameByparentId(parent, animalDtoList), l);
                }
            }
        }
        System.out.println(m);
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

class AnimalDto{
    int id;
    int parentid;
    String name;
    String color;

    AnimalDto(int id,int parentid,String name,String color){
        this.id = id;
        this.color = color;
        this.parentid = parentid;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getParentid() {
        return parentid;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
    public String toString(){
        return name;
    }
}
class SubAnimalDto {
    String name;
    SubAnimalDto(String name){
        this.name = name;
    }
}
