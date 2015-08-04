package com.inna.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tests")
public class Main {

    @RequestMapping
    /*
            /test
            controller_mapping + method_mapping
            /test + "" = /test

            open PREFIX + to_jsp + SUFFIX
    */
    public String m1() {
        return "to_jsp";
    }

    @RequestMapping("/a")
    public String m2() {
        /*
            /test/a
            /test + /a = /test/a

            go to /test/b in browser
        */
        return "redirect:/tests/b";
    }

    @RequestMapping("/b/c/d")
    public String m3() {
        /*
            /test/b/c/d
            /test + /b/c/d = /test/b/c/d

            go to /test in browser
        */
        return "redirect:/tests";
    }

}
