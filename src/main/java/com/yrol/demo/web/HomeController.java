package com.yrol.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yrol.demo.domain.User;

@Controller
public class HomeController {

	/**
	 * Creating an object map using the key "formData" (can be any name)
	 * Passing the User object to be used by "pages/index.html" - to assign values entered by the user in the form
	 * */
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("formData", new User());
		return "pages/index";
	}

	/**
	 * Passing the User object to be used by "pages/result.html" - to read and display data entered by the user
	 * */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String processFormData(User user) {

		return "pages/results";
	}
}
