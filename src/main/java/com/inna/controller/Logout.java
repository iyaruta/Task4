package com.inna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class Logout {

    @RequestMapping(method = RequestMethod.GET)
    public String log (HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null){
            session.invalidate();
        }
        return "/index";
    }
}
