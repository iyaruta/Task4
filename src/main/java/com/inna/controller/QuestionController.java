package com.inna.controller;

import com.inna.dao.OptionDao;
import com.inna.dao.QuestionDao;
import com.inna.dao.TestDao;
import com.inna.dao.jdbc.TestDaoImpl;
import com.inna.data.Option;
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

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private TestDao testDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private OptionDao optionDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id,  Model model) {
        Question question = questionDao.get(id);
        model.addAttribute("question", question);

        List<Option> options = optionDao.findByQuestionId(id);
        model.addAttribute("option", options);

        return "test/question";
    }


    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(@RequestParam Long testId, Model model) {
        model.addAttribute("testId", testId);
        return "test/questionNew";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create( Question question) {
        questionDao.save(question);
        return "redirect:/test/" + question.getTestId();
    }

    @RequestMapping(value = "/{id}/remove", method = RequestMethod.GET)
    public String removeQuestionId(@PathVariable("id") Long questionId) {
        Question question = questionDao.get(questionId);
        questionDao.removeQuestion(questionId);
        return "redirect:/question/" + question.getTestId();
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String updateQuestion(@PathVariable Long id, Model model){
        Question question = questionDao.get(id);
        model.addAttribute("question", question);
        return "test/questionUpdate";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateQuestionCreate(Question question){
        questionDao.update(question);
        Question question1 = questionDao.get(question.getId());
        return "redirect:/test/" + question1.getTestId();
    }

}
