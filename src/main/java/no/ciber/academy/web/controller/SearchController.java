package no.ciber.academy.web.controller;

import no.ciber.academy.model.repository.BookInfoRepository;
import no.ciber.academy.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SearchController {

    @Autowired
    private BookInfoRepository bookInfoRepository;

    @Autowired
    private SearchService searchService;

    //TODO consider if the searchParameter is ISBN or title
    @RequestMapping("/search")
    public String search(Model bookListSearchModel, @RequestParam String searchParameter){
        bookListSearchModel.addAttribute("listOfBooks", searchService.search(searchParameter));
        return "booklist";
    }

}
