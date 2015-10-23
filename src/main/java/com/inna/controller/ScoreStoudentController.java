package com.inna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scoreStudent")
public class ScoreStoudentController {

    @RequestMapping
    public String score() {
        return "scoreStudent";
    }
}
