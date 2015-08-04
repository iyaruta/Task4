package com.inna.controller;

import com.inna.dao.SignupDao;
import com.inna.data.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private SignupDao signupDao;

    @RequestMapping(method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(Registration registration) {
        signupDao.save(registration);
        return "redirect:/login";
    }

    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

}