package com.inna.controller;

import com.inna.dao.CourseDao;
import com.inna.data.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/addCourse")
public class AddCourseController {

    @Autowired
    public CourseDao courseDao;

    @RequestMapping(method = RequestMethod.GET)
    public String course(){
        return "addCourse";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String coursePost(Course course) {
        courseDao.saveCourse(course);
        return "redirect:/teacher";
    }

    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

}
