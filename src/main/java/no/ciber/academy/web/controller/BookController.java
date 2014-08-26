package no.ciber.academy.web.controller;

import no.ciber.academy.library.BookInfo;
import no.ciber.academy.repository.BookInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/books")
@Controller
public class BookController {

    @Autowired
    private BookInfoRepository bookInfoRepository;

    @RequestMapping("/addbook")
    public String addBook(Model bookModel){
        bookModel.addAttribute("bookInfo", new BookInfo());

        return "bookinfo";
    }

    @RequestMapping("/save")
    public String save(BookInfo newBook, Model bookModel){
        bookInfoRepository.save(newBook);
        bookModel.addAttribute("bookInfo", newBook);

        return "bookinfo";
    }

    @RequestMapping("/list")
    public String list(Model listOfBooksModel){

        listOfBooksModel.addAttribute("listOfBooks", bookInfoRepository.findAll());

        return "list";
    }

    //TODO: Delete books


}
