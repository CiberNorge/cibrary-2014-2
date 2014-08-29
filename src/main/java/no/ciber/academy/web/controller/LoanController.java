package no.ciber.academy.web.controller;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.BookInfo;
import no.ciber.academy.model.User;
import no.ciber.academy.model.repository.BookInfoRepository;
import no.ciber.academy.model.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/loans", method= RequestMethod.POST)
public class LoanController {
    @Autowired
    private BookInfoRepository bookInfoRepository;
    
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/loan")
	public String loan(Model model, @ModelAttribute("bookInfo") BookInfo bookInfo, RedirectAttributes redirect, HttpSession session) {
		try {
			Iterator<Book> iterator = bookInfo.getAvailable().iterator();
			Book book = iterator.next();
			iterator.remove();
			User user = (User) session.getAttribute("user");
			user.getLoans().add(book);
			bookInfo = bookInfoRepository.save(bookInfo);
			user = userRepository.save(user);
			session.setAttribute("user", user);
		} catch (Exception e) {
			redirect.addFlashAttribute("error", "Book disappeared while loaning.");
	    	return "redirect:/books/info/" + bookInfo.getId();
		}
		redirect.addFlashAttribute("message", "You successfully got the book.");
    	return "redirect:/user/mybooks";
	}
	
	@RequestMapping("/return")
	public String returnBook(Model model, Book book, RedirectAttributes redirect, HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			user.getLoans().remove(book);
			book.getBookInfo().getAvailable().add(book);
		} catch (Exception e) {
			redirect.addFlashAttribute("error", "Book disappeared while returning.");
			return "redirect:/user/mybooks";
		}
		redirect.addFlashAttribute("message", "You successfully returned the book.");
    	return "redirect:/user/mybooks";
	}
}
