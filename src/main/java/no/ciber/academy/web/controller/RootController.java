package no.ciber.academy.web.controller;

import no.ciber.academy.model.User;
import no.ciber.academy.model.repository.BookInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
    @Autowired
    private BookInfoRepository bookInfoRepository;

    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("user", new User());
    	model.addAttribute("lostOfBooks", bookInfoRepository.findAll());
        return "index";
    }
}
