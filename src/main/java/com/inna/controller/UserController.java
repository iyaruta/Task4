package com.inna.controller;

import com.inna.dao.CourseDao;
import com.inna.dao.ElectiveDao;
import com.inna.dao.UserDao;
import com.inna.data.Course;
import com.inna.data.Elective;
import com.inna.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserDao userDao;

    @Autowired
    public ElectiveDao electiveDao;

    @RequestMapping(method = RequestMethod.GET)
    public String adminUser(Model model) {
//        HttpSession session = request.getSession();
//        User user = (User)session.getAttribute("user");
        List<Elective> electives = electiveDao.findAll();
        model.addAttribute("electives", electives);



        return "user";

    }
}