package com.inna.controller;

import com.inna.dao.TestDao;
import com.inna.data.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/startTest")
public class StartTestController {

    @Autowired
    public TestDao testDao;

    @RequestMapping
    public String test() {
        return "startTest";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start(Model model ) {
 //       Test test = testDao.findAll(question);
//        model.addAttribute("question", test.getQuestion());
//        model.addAttribute("id", test.getId());

        return "startTest";
    }

//    @RequestMapping(method = RequestMethod.POST)



}
