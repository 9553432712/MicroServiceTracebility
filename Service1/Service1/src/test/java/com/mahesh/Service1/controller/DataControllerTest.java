package com.mahesh.Service1.controller;

import com.mahesh.Service1.dto.AnimalDto;
import com.mahesh.Service1.service.ServiceData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class DataControllerTest extends AbstractTest{
    @Mock
    Logger LOG;
    @Mock
    ServiceData serviceData;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    AnimalDto animalDto = new AnimalDto(1, 0, "Snake", "Black");

    @Test
    public void testCreate() throws Exception {
        when(serviceData.create(any())).thenReturn(animalDto);

        String uri = "/create";
        String inputJson = super.mapToJson(animalDto);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertNotNull(content);
    }

    @Test
    public void getById() throws Exception {
        when(serviceData.get(anyInt())).thenReturn(animalDto);

        String uri = "/get/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertNotNull(content);
    }

    @Test
    public void testGetAll() throws Exception {
        when(serviceData.getAll()).thenReturn(Arrays.<AnimalDto>asList(animalDto));
        String uri = "/get-db-data";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertNotNull(content);
    }

    @Test
    public void testFormatData() throws Exception {
        when(serviceData.formatData()).thenReturn(new HashMap() {{
            put("String", "String");
        }});

        String uri = "/get";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertNotNull(content);
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(serviceData).delete(anyInt());

        String uri = "/delete/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void testEdit() throws Exception {
        when(serviceData.edit(any())).thenReturn(animalDto);

        String uri = "/edit";
        String inputJson = super.mapToJson(animalDto);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertNotNull(content);
    }
}

