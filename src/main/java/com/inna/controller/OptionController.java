package com.inna.controller;

import com.inna.dao.OptionDao;
import com.inna.dao.QuestionDao;
import com.inna.data.Option;
import com.inna.data.Question;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/option")
public class OptionController {

    @Autowired
    private OptionDao optionDao;

    @Autowired
    private QuestionDao questionDao;

    @RequestMapping(value = "/{/id}", method = RequestMethod.GET)
    public String get(@RequestParam Long id, Model model){
        Option option = optionDao.get(id);
        model.addAttribute("option", option);
        return "redirect:/question" + option.getQuestionId();

    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(@RequestParam Long questionId, Model model) {

        model.addAttribute("questionId", questionId);
        return "test/optionNew";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(Option option) {
        optionDao.save(option);
        return "redirect:/question/" + option.getQuestionId();
    }

    @RequestMapping(value = "/{id}/remove", method = RequestMethod.GET)
    public String removeQuestionId(@PathVariable("id") Long optionId) {
        Option option = optionDao.get(optionId);
        optionDao.removeOptions(optionId);
        return "redirect:/question/" + option.getQuestionId();
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String updateOption(@PathVariable Long id, Model model ) {
        Option option = optionDao.get(id);
        model.addAttribute("option", option);
        return "test/option";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateOptionCreate(Option option) {
        optionDao.update(option);
        Option option1 = optionDao.get((long)option.getId());
        return "redirect:/question/" + option1.getQuestionId();
    }
}
