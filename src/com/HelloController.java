package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    @RequestMapping(value= "/error", method = RequestMethod.GET)
    public String printError(ModelMap model){
        model.remove("message");
        model.addAttribute("message","Incorrect username or password!");
        return "login";
    }
    @RequestMapping(value = "/index")
    public String login (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap model){
        String name = httpServletRequest.getParameter("name");
        model.remove("message");
        model.addAttribute("message","Welcome to use Precision Medicine Matching System, " + name + "!");
        return "index";
    }
    @RequestMapping(value = "/register")
    public String register (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap model){
        String name = httpServletRequest.getParameter("name");
        String key = httpServletRequest.getParameter("key");
        model.remove("message");
        model.addAttribute("message","Successfully registered!</br>Welcome to use Precision Medicine Matching System, " + name + "!");
        return"index";
    }
    @RequestMapping(value = "/continue")
    public String Continue(ModelMap model){
        model.remove("message");
        model.addAttribute("message","Welcome to use Precision Medicine Matching System!");
        return"index";
    }

}
