package com.mahesh.Service1.service;

import com.mahesh.Service1.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ServiceClass {

//    private static final Logger LOG = Logger.getLogger(ServiceClass.class.getName());

    @Autowired
    RestTemplate restTemplate;

    @Value("${service2.url}")
    private String service2Url;


    @Value("${service3.url}")
    private String service3Url;

    public Object callService(Employee employee) {
//        LOG.log(Level.INFO, "Service2 is getting called in service1");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(service2Url, String.class);
        String e = responseEntity.getBody();
//        LOG.log(Level.INFO, "Service3 is getting called in service1");
        ResponseEntity<String> responseEntity2 = restTemplate.postForEntity(service3Url, employee, String.class);
        String result = e+responseEntity2.getBody();
        return result;
    }
}
