package com.booker.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.booker.services.users.User;
import com.booker.services.users.UsersService;
import com.booker.services.users.exceptions.ErrorViewUtils;

@Controller
public class LoginController {

	@Autowired
	UsersService userService;

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	ModelAndView login(HttpSession session, @RequestParam("username") String userName,
			@RequestParam("password") String password) {
		return validateLogin(userName, password);
	}

	private ModelAndView validateLogin(String userName, String password) {
		ModelAndView view = new ModelAndView();
		try {
			User user = userService.valiateUser(userName, password);
			session.setAttribute("user", user);
			view.setViewName("home");
			view.addObject("user", user);
			view.addObject("roles", user.getRoles());
		} catch (Exception e) {
			ErrorViewUtils.createErrorView(view, e.getMessage());
		}
		return view;
	}
}
