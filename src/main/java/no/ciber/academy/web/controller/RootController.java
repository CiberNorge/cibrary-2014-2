package no.ciber.academy.web.controller;

import java.util.ArrayList;
import java.util.List;

import no.ciber.academy.model.BookInfo;
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
    	List<BookInfo> books = new ArrayList<BookInfo>();
    	int i = 0;
    	for (BookInfo book : bookInfoRepository.findAll()) {
    		books.add(book);
    		if (i++ > 6) break;
    	}
    	model.addAttribute("listOfBooks", books);
        return "index";
    }
}
