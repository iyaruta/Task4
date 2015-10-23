package com.inna.controller;

import com.inna.dao.QuestionDao;
import com.inna.dao.TestDao;
import com.inna.data.Question;
import com.inna.data.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    public TestDao testDao;

    @Autowired
    public QuestionDao questionDao;

    // path: /test
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        List<Test> tests = testDao.findAll();
        model.addAttribute("list", tests);
        return "test/testList";
    }


    // path: /test/12
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        Test test = testDao.get(id);
        model.addAttribute("test", test);

        List<Question> questions = questionDao.findByTestId(id);
        model.addAttribute("questions", questions);
        return "test/test";
    }


}
