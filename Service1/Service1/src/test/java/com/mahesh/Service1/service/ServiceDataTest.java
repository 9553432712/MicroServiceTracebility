package com.mahesh.Service1.service;

import com.mahesh.Service1.dto.AnimalDto;
import com.mahesh.Service1.dto.SubAnimalDto;
import com.mahesh.Service1.entity.AnimalEntity;
import com.mahesh.Service1.repository.AnimalRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

public class ServiceDataTest {
    @Mock
    Logger LOG;
    @Mock
    AnimalRepository animalRepository;
    @InjectMocks
    ServiceData serviceData;

    AnimalDto animalDto = new AnimalDto(1, 0, "cobra", "black");
    AnimalEntity animalEntity = animalDto.toData();
    List<AnimalDto> animalDtoList;
    List<AnimalEntity> animalEntityList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        animalDtoList = new ArrayList<>();
        animalEntityList = new ArrayList<>();
        animalDtoList.add(animalDto);
        animalEntityList.add(animalEntity);
    }

    @Test
    public void testCreate() throws Exception {
        when(animalRepository.save(any(AnimalEntity.class))).thenReturn(animalEntity);
        AnimalDto result = serviceData.create(animalDto);
        Assert.assertEquals(animalDto, result);
    }

    @Test
    public void testGetAll() throws Exception {
        when(animalRepository.findAll()).thenReturn(animalEntityList);
        List<AnimalDto> result = serviceData.getAll();
        Assert.assertNotNull(result);
    }

    @Test
    public void testGet() throws Exception {
        when(animalRepository.findById(anyInt())).thenReturn(Optional.of(animalEntity));
        AnimalDto result = serviceData.get(1);
        Assert.assertEquals(animalDto, result);
    }

    @Test
    public void testEdit() throws Exception {
        when(animalRepository.save(any(AnimalEntity.class))).thenReturn(animalEntity);
        AnimalDto result = serviceData.edit(animalDto);
        Assert.assertEquals(animalDto, result);
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(animalRepository).deleteById(anyInt());
        serviceData.delete(1);
    }

    @Test
    public void testFormatData() throws Exception {
        when(animalRepository.findAll()).thenReturn(animalEntityList);
        Map<String, List<SubAnimalDto>> m = new HashMap();
        m.put(animalDto.getName(), new ArrayList<SubAnimalDto>(Arrays.asList(new SubAnimalDto(animalDto.getName()))));
//        when(serviceData.formatData(animalDtoList)).thenReturn(m);
        Map result = serviceData.formatData();
        Assert.assertNotNull(result);
    }

    @Test
    public void testFormatDataWithListInput() throws Exception {
        Map result = serviceData.formatData(animalDtoList);
        Assert.assertNotNull(result);
    }
}

