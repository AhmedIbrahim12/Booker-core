package com.booker.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booker.controllers.annotations.RestEndpoint;
import com.booker.services.users.User;

@RestController
@RestEndpoint
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public List<String> getUserRoles(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<String> roles = user.getRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toList());
		return roles;
	}
}
