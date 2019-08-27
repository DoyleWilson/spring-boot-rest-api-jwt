package com.doyle.challenge.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @GetMapping("/")
    public String list(){
        return "employees";
    }
}
