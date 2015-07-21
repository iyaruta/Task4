package com.inna.controller;

import com.inna.data.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    public static void main(String[] args) {
        System.out.println("Sef");
    }

    @RequestMapping(method = RequestMethod.GET)
    public String view() {

        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String home(Login login, Model model ) {

        model.addAttribute("name", login.getName());
        model.addAttribute("password", login.getPassword());

        return "login";
    }

}