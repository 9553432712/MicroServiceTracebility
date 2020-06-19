package com.mahesh.Service2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceClass {

    @Autowired
    RestTemplate restTemplate;

    @Value("service2.url")
    private String service2Url;

    public void callService() {

        restTemplate.getForEntity(service2Url, Object.class);
    }
}
