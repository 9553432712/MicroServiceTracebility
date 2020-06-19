package com.mahesh.Service2.controller;

import com.mahesh.Service2.dto.Employee;
import com.mahesh.Service2.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    ServiceClass serviceClass;

    @GetMapping("/")
    public String welcome(){
        return "Hello ";
    }
}
