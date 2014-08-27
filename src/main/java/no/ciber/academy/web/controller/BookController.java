package no.ciber.academy.web.controller;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.BookInfo;
import no.ciber.academy.model.repository.BookInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        return "bookadd";
    }
    
    @RequestMapping("/addcopy")
    public String addCopy(Model model, @ModelAttribute("book") BookInfo bookInfo) {
//    	model.addAttribute("book", newCopy);
    	return "redirect:/books/info/" + bookInfo.getId();
    }

    @RequestMapping("/save")
    public String save(BookInfo newBook, Model bookModel){
        newBook = bookInfoRepository.save(newBook);
        bookModel.addAttribute("bookInfo", newBook);

        return "redirect:/books/info/" + newBook.getId();
    }

    @RequestMapping("/list")
    public String list(Model listOfBooksModel){
        listOfBooksModel.addAttribute("listOfBooks", bookInfoRepository.findAll());

        return "booklist";
    }
    
    @RequestMapping(value = "/info/{id}", method=RequestMethod.GET)
    public String info(Model model, @PathVariable("id") long id, RedirectAttributes redirect) {
    	BookInfo bookInfo = bookInfoRepository.findOne(id);
    	if (bookInfo == null) {
    		redirect.addFlashAttribute("error", "Book not found!");
    		return "redirect:/books/list";
    	}
    	model.addAttribute("bookInfo", bookInfo);
    	return "bookinfo";
    }

    //TODO: Delete books


}
