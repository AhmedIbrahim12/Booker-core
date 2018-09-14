package com.booker.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(path = "/hello")
	public @ResponseBody String index1() {
		LOG.info("GET called on /hello resource");
		return "ahmed api";
	}

	@RequestMapping(path = "/hello", method = RequestMethod.POST)
	public @ResponseBody String index2(@RequestParam("firstName") String userName) {
		LOG.info("POST called on /hello resource");
		return "Hello " + userName;
	}
}
