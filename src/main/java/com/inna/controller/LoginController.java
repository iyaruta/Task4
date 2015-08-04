package com.inna.controller;

import com.inna.dao.SignupDao;
import com.inna.data.Login;
import com.inna.data.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SignupDao signupDao;

    @RequestMapping(method = RequestMethod.GET)
    public String view() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String home(Login login, Model model, HttpServletRequest req) {
        Registration registration = signupDao.getByEmail(login.getEmail());
        String password = toMD5(login.getPassword());

        if (Objects.equals(password, registration.getPassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("user", registration);
            if (registration.getRoleId() == 1) {
                return "redirect:/admin";
            } else if (registration.getRoleId() == 2) {
                return "redirect:/test";
            } else  if(registration.getRoleId() == 3){
                return "redirect:/indexCourse";
            } else if(registration.getRoleId() == 4) {
                return "redirect:/course";
            }
        }

        model.addAttribute("error_password", true);
        return "login";
    }

    @RequestMapping("/home")
    public String method(){
        return "redirect:/login/home";
    }


    public String toMD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}