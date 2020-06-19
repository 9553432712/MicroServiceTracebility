package com.mahesh.Service3.controller;

import com.mahesh.Service3.dto.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String welcome(){
        return "Hello ";
    }

    @PostMapping("/")
    public String call(@RequestBody Employee employee){
        return employee.toString();
    }

}
