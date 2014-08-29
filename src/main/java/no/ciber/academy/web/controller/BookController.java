package no.ciber.academy.web.controller;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.BookInfo;
import no.ciber.academy.model.User;
import no.ciber.academy.model.repository.BookInfoRepository;
import no.ciber.academy.model.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequestMapping("/books")
@Controller
public class BookController {

    @Autowired
    private BookInfoRepository bookInfoRepository;
    
    @Autowired
    private BookRepository bookRepository;
	
	@Autowired
	private LoanController loanController;
    
    @RequestMapping("/addbook")
    public String addBook(Model bookModel){
        bookModel.addAttribute("bookInfo", new BookInfo());

        return "bookadd";
    }
    
    @RequestMapping("/action")
    public String action(Model model, @ModelAttribute("bookInfo") BookInfo bookInfo, @RequestParam(required=false, value="loan") String loan, @RequestParam(required=false, value="add") String add, @RequestParam(required=false, value="edit") String edit, RedirectAttributes redirect, HttpSession session) {
    	if (add != null) return addCopy(model, bookInfo, redirect);
    	if (edit != null) {
    		model.addAttribute("bookInfo", bookInfo);
    		return "bookadd";
    	}
    	if (loan != null) {
    		return loanController.loan(model, bookInfo, redirect, session);
    	}
    	redirect.addFlashAttribute("error", "An error occurred while dispatching (this should never happen!)");
    	return "redirect:/";
    }
    
    @RequestMapping("/addcopy")
    public String addCopy(Model model, @ModelAttribute("book") BookInfo bookInfo, RedirectAttributes redirect) {
    	Book newCopy = new Book();
    	newCopy.setBookInfo(bookInfo);
    	newCopy = bookRepository.save(newCopy);
    	bookInfo.getCopies().add(newCopy);
    	bookInfo.getAvailable().add(newCopy);
    	bookInfo = bookInfoRepository.save(bookInfo);
    	model.addAttribute("bookInfo", bookInfo);
        redirect.addFlashAttribute("message", "Another copy of your book has been added.");
    	
    	return "redirect:/books/info/" + bookInfo.getId();
    }

    @RequestMapping("/save")
    public String save(@Valid BookInfo newBook, BindingResult result, Model bookModel, RedirectAttributes redirect) {
        if(result.hasErrors())
            return "bookadd";
        newBook = bookInfoRepository.save(newBook);
        bookModel.addAttribute("bookInfo", newBook);
        addCopy(bookModel, newBook, redirect);
        redirect.addFlashAttribute("message", "You new book has been added to the library.");

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
