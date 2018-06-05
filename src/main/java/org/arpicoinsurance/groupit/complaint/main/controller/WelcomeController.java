package org.arpicoinsurance.groupit.complaint.main.controller;

import javax.servlet.http.HttpSession;
import org.arpicoinsurance.groupit.complaint.main.dto.UsersDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String redirectToLoginPage() {
		return "login";
	}

	@RequestMapping("/login")
	public String viewLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView authenticate(HttpSession httpSession, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) throws Exception {

		System.out.println(username +"-"+ password);
		ModelAndView modelAndView = new ModelAndView();

		UsersDto userModel = new UsersDto();
		if (userModel != null) {
			httpSession.setAttribute("user", userModel);
			modelAndView.setViewName("home");
		} else {
			modelAndView.addObject("login_error", "Username or password incorrect");
			modelAndView.setViewName("login");
		}

		return modelAndView;

	}

	@RequestMapping("/home")
	public String viewWelcomePage() {
		return "home";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "logout";
	}

}
