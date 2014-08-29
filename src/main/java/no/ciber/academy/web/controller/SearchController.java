package no.ciber.academy.web.controller;

import no.ciber.academy.model.repository.BookInfoRepository;
import no.ciber.academy.service.SearchService;
import org.hibernate.search.exception.EmptyQueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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


    @RequestMapping("/search")
    public String search(Model bookListSearchModel, @RequestParam String searchParameter, ModelMap model){
        try {
            bookListSearchModel.addAttribute("listOfBooks", searchService.search(searchParameter));
        }catch (EmptyQueryException e){
            model.addAttribute("error", "Queries with stop words will not return results. Try searching for a full title or author name.");
        }
        return "booklist";
    }






}
