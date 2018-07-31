package com.javatechie.freemarker.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.javatechie.freemarker.api.User;

@Controller
public class ApplicationController {

	@GetMapping("/greeting/{input}")
	public String greeting(@PathVariable String input, Model model) {
		String welcomeMessage = "Hi " + input + " welcome to java techie";
		model.addAttribute("message", welcomeMessage);
		return "welcome";
	}

	@GetMapping("/getUsers")
	public String getUsers(Model model) {
		List<User> users = Stream
				.of(new User(1, "John", "USA"), new User(2, "Pitter", "IND"), new User(3, "Washim", "PAK"))
				.collect(Collectors.toList());
		model.addAttribute("users", users);
		return "userList";

	}

}
