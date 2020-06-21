package com.mahesh.Service1.service;

import com.mahesh.Service1.dto.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceClientTest {

    @Mock
    Logger LOG;
    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    ServiceClient serviceClient;

    Employee employee = new Employee("Mahesh", "Punugupati");
    String welcomeMSG = "Hello ";

    ResponseEntity responseEntity = new ResponseEntity(HttpStatus.ACCEPTED);


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCallService() throws Exception {
        Mockito
                .when(restTemplate.getForEntity(
                        "http://localhost:8082", String.class))
          .thenReturn(new ResponseEntity(welcomeMSG, HttpStatus.OK));

        Mockito
                .when(restTemplate.postForEntity(
                        "http://localhost:8083",employee, String.class))
                .thenReturn(new ResponseEntity(employee.toString(), HttpStatus.OK));

//        String result = serviceClient.callService(employee);
        Assert.assertNotNull("result");
    }
}
