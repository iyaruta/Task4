package com.inna.controller;

import com.inna.dao.QuestionDao;
import com.inna.data.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionDao questionDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        Question question = questionDao.get(id);
        model.addAttribute(question);
        return "test/question";
    }


    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(@RequestParam long testId, Model model) {
        model.addAttribute("testId", testId);
        return "test/questionNew";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(Question question) {
        questionDao.save(question);
        return "redirect:/test/" + question.getTestId();
    }


}
