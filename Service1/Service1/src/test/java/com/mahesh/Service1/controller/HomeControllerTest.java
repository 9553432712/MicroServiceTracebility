package com.mahesh.Service1.controller;

import com.mahesh.Service1.dto.Employee;
import com.mahesh.Service1.service.ServiceClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


public class HomeControllerTest extends AbstractTest{

    @Mock
    ServiceClient serviceClient;

    Employee empployee = new Employee("mahesh","punugupati");
    String welcomeMSG = "Hello Service1 Up";

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testWelcome() throws Exception {
        String uri = "/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(welcomeMSG, content);
    }

    @Test
    public void testCallingService() throws Exception {
        when(serviceClient.callService(any())).thenReturn("Hello "+ empployee.toString());

        String uri = "/";
        String inputJson = super.mapToJson(empployee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Hello "+ empployee.toString());
    }
}
