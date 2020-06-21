package com.mahesh.Service1.controller;

import com.mahesh.Service1.dto.Employee;
import com.mahesh.Service1.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    ServiceClient serviceClient;

    @GetMapping("/")
    public String welcome(){
        return "Hello Service1 Up";
    }

    @PostMapping("/")
    public String callingService(@RequestBody Employee employee){
        return serviceClient.callService(employee);
    }
}
