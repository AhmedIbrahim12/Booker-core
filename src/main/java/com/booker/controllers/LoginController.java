package com.booker.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booker.controllers.annotations.RestEndpoint;
import com.booker.services.users.User;
import com.booker.services.users.UsersService;

@RestController
@RestEndpoint
public class LoginController {

	@Autowired
	UsersService userService;

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(HttpSession session, @RequestParam("username") String userName,
			@RequestParam("password") String password) {
		User user = null;
		try {
			user = userService.valiateUser(userName, password);
			session.setAttribute("user", user);
		} catch (Exception e) {
			return new User();
		}
		return user;
	}
}
