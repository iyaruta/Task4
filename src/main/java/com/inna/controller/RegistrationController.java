package com.inna.controller;

import com.inna.data.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(Registration registration, Model model) {
        model.addAttribute("name", registration.getName());
        model.addAttribute("password", registration.getPassword());
        model.addAttribute("password2", registration.getPassword2());
        model.addAttribute("email", registration.getEmail());

        return "registration";
    }
}