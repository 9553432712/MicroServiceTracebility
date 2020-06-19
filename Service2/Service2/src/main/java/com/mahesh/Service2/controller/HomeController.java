package com.mahesh.Service2.controller;

import com.mahesh.Service2.dto.Employee;
import com.mahesh.Service2.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HomeController {

    private static final Logger LOG = Logger.getLogger(HomeController.class.getName());

    @Autowired
    ServiceClass serviceClass;

    @GetMapping("/")
    public String welcome(){
        LOG.log(Level.INFO, "in service2");
        return "Hello ";
    }
}
