package no.ciber.academy.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import no.ciber.academy.model.Book;
import no.ciber.academy.model.BookInfo;
import no.ciber.academy.model.User;
import no.ciber.academy.model.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/user", method= RequestMethod.POST)
public class UserController {
	
	@Autowired
	private UserRepository repository;

	//@Inject
	//User user;
	
	@RequestMapping("/")
	public String login_register(HttpSession session, Model model, @ModelAttribute("user") User user, @RequestParam(required=false, value="register") String register, RedirectAttributes redirect) {
		if (register != null)
			return "register";
		User loggedUser = repository.findByName(user.getName());
		if (loggedUser == null || !loggedUser.getPassword().equals(user.getPassword())) {
			redirect.addFlashAttribute("error", "Username or password incorrect!");
			return "redirect:/";
		}
		session.setAttribute("user", loggedUser);
		return "redirect:/";
	}
	
	@RequestMapping("/signup")
	@Transactional
	public String signup(HttpSession session, Model model, @ModelAttribute("user") User user, @RequestParam("repeat") String repeat, RedirectAttributes redirect) {
		if (!user.getPassword().equals(repeat)) {
			model.addAttribute("error", "The entered passwords do not match!");
			return "register";
		}
		if (user.getPassword().length() < 3) {
			model.addAttribute("error", "The entered password is too simple!");
			return "register";
		}
		if (repository.findByName(user.getName()) != null) {
			model.addAttribute("error", "User name already in use!");
			return "register";
		}
		redirect.addFlashAttribute("message", "Welcome " + user.getName() +"!");
		user = repository.save(user);
		return login_register(session, model, user, null, redirect);
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("user");
		model.addAttribute("user", new User());
		return "redirect:/";
	}
	
	@RequestMapping(value = "/profile", method=RequestMethod.GET)
	public String profile() {
		return "userprofile";
	}
	
	@RequestMapping(value = "/mybooks", method=RequestMethod.GET)
	@Transactional
	public String mybooks(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("listOfBooks", user.getLoans());
		return "mybooks";
	}
}