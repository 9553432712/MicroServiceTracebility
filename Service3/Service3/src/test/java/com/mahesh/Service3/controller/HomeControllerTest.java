package com.mahesh.Service3.controller;

import com.mahesh.Service3.dto.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


public class HomeControllerTest extends AbstractTest{


    Employee empployee = new Employee("mahesh","punugupati");

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testCallingService() throws Exception {
        String uri = "/";
        String inputJson = super.mapToJson(empployee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, empployee.toString());
    }
}
