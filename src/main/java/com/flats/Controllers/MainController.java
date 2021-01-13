package com.flats.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MainController {



    //ajax
    @RequestMapping("/hello")
    public String display(HttpServletRequest req, Model m) {

        String msg="Sorry "+ "name"+". You entered an incorrect password";
        m.addAttribute("message", msg);

        return "test";
    }
}
