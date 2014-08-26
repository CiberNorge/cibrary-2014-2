package no.ciber.academy.web.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login_register(HttpSession session, Model model, @ModelAttribute("user") User user, @RequestParam(required=false, value="register") String register) {
		if (register != null)
			return "register";
		User loggedUser = repository.findByName(user.getName());
		if (loggedUser == null || !loggedUser.getPassword().equals(user.getPassword())) {
			model.addAttribute("error", "Username or password incorrect!");
			return "index";
		}
		User anonymizedUser = new User();
		anonymizedUser.setName(loggedUser.getName());
		session.setAttribute("user", anonymizedUser);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	@Transactional
	public String signup(HttpSession session, Model model, @ModelAttribute("user") User user, @RequestParam("repeat") String repeat, RedirectAttributes redirect) {
		if (!user.getPassword().equals(repeat)) {
			model.addAttribute("error", "The entered passwords do not match!");
			return "register";
		}
		if (repository.findByName(user.getName()) != null) {
			model.addAttribute("error", "User name already in use!");
			return "register";
		}
		redirect.addFlashAttribute("message", "Welcome " + user.getName() +"!");
		user = repository.save(user);
		return login_register(session, model, user, null);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("user");
		model.addAttribute("user", new User());
		return "index";
	}
}