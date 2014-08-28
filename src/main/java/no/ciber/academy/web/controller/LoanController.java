package no.ciber.academy.web.controller;

import java.util.Iterator;

import javax.transaction.Transactional;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.BookInfo;
import no.ciber.academy.model.User;
import no.ciber.academy.model.repository.BookInfoRepository;
import no.ciber.academy.model.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoanController {
    @Autowired
    private BookInfoRepository bookInfoRepository;
    
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public String loan(Model model, BookInfo bookInfo, User user, RedirectAttributes redirect) {
		try {
			Iterator<Book> iterator = bookInfo.getAvailable().iterator();
			Book book = iterator.next();
			iterator.remove();
			user.getLoans().add(book);
			bookInfo = bookInfoRepository.save(bookInfo);
			user = userRepository.save(user);
		} catch (Exception _) {
			redirect.addFlashAttribute("error", "Book disappeared while loaning.");
	    	return "redirect:/books/info/" + bookInfo.getId();
		}
		redirect.addFlashAttribute("message", "You successfully got the book.");
    	return "redirect:/books/info/" + bookInfo.getId(); // FIXME: go to user book list instead?
	}
}
