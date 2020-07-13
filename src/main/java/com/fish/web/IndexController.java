package com.fish.web;

import com.fish.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping(value = {"/index", "/"})
    public String index(HttpServletRequest request){
        if( request.getSession().getAttribute("loginUser")==null){
            return "login";
        }
        return "views/index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(UserInfo user, Model model, HttpServletRequest request){
        try{
            if(user.getUsername().equals("admin") && user.getPassword().equals("123456")){
                request.getSession().setAttribute("loginUser",user);
                return "views/index";
            }
            else{
                model.addAttribute("errMsg","用户名或者密码错误");
                return "login";
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            model.addAttribute("errMsg",ex.getMessage());
            return "login";
        }
    }

}
