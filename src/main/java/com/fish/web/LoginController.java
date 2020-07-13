package com.fish.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;
import java.util.Date;

@Controller
public class LoginController {

    @GetMapping("/tologin")
    public String login(Model model){

        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));

        return "login";
    }

}
