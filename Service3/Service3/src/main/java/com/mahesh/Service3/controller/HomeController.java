package com.mahesh.Service3.controller;

import com.mahesh.Service3.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HomeController {

    private static final Logger LOG = Logger.getLogger(HomeController.class.getName());

    @GetMapping("/")
    public String welcome(){
        return "Hello ";
    }

    @PostMapping("/")
    public String call(@RequestBody Employee employee){
        return employee.toString();
    }

}
