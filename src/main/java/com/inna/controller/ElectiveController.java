package com.inna.controller;

import com.inna.dao.ElectiveDao;
import com.inna.data.Elective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/elective")
public class ElectiveController {

    @Autowired
    public ElectiveDao electiveDao;


    @RequestMapping
    public String elective() {
        return "elective";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        Elective elective = electiveDao.get(id);
        model.addAttribute("elective", elective);
        return "elective";
    }
}
