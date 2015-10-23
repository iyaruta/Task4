package com.inna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/selectedTest")
public class SelectedController  {

    @RequestMapping
    public String addSelectedTest(){
        return "selectedTest";
    }


}
