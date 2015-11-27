package com.inna.controller;

import com.inna.dao.TestDao;
import com.inna.data.Registration;
import com.inna.data.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/addTest")
public class AddTestController {

    @RequestMapping
    public String addTest() {
        return "addTest";
    }

    @Autowired
    public TestDao testDao;

    @RequestMapping(method = RequestMethod.POST)
    public String register(Test test) {
        testDao.saveQuestion(test);
        return "redirect:test";
    }
}
