package com.mahesh.Service1.controller;

import com.mahesh.Service1.dto.Employee;
import com.mahesh.Service1.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    ServiceClient serviceClient;

    @GetMapping("/")
    public String welcome(){
        return "Hello Service1 Up";
    }

    @PostMapping("/")
    public Object welcomeName(@RequestBody Employee employee){
        return serviceClient.callService(employee);
    }

}
