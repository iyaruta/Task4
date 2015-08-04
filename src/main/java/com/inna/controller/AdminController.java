package com.inna.controller;

import com.inna.dao.UserDao;
import com.inna.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public UserDao userDao;

    @RequestMapping
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String adminUser(@RequestParam int role, Model model) {
        List<User> users = userDao.findByRoleId(role);
        model.addAttribute("users", users);
        model.addAttribute("role", role);
        return "admin";
    }
}
