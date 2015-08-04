package com.inna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/indexCourse")
public class IndexController {

    @RequestMapping
    public String index() {
        return "indexCourse";
    }
}
