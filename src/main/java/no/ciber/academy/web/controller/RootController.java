package no.ciber.academy.web.controller;

import no.ciber.academy.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("user", new User());
        return "index";
    }
}
