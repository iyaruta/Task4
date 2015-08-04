package com.inna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addCourse")
public class AddCourse {

    @RequestMapping
    public String add() {
        return "addCourse";
    }
}
