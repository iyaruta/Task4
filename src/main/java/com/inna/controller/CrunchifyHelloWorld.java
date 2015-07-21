package com.inna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CrunchifyHelloWorld {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}

    @RequestMapping("/inna")
    public String inna(Person person, Model model) {
        model.addAttribute("name", person.getName());
        model.addAttribute("age", person.getAge() + 100);
        return "inna";
    }

    @RequestMapping("/user/{name}")
    public String one(@PathVariable String name, Model model) {

        return "home";
    }

    public static class Person {
        int age;
        String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
