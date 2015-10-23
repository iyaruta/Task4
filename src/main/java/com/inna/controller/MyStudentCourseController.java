package com.inna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MyStudentCourse")
public class MyStudentCourseController {

    @RequestMapping
    public String myStudent() {
        return "MyStudentCourse";
    }
}
