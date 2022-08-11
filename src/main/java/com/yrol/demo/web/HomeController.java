package com.yrol.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yrol.demo.domain.User;

@Controller
public class HomeController {

	/**
	 * Creating an object map using the key "formData" (can be any name) Passing the
	 * User object to be used by "pages/index.html" - to assign values entered by
	 * the user in the form
	 */
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("formData", new User());
		return "pages/index";
	}

	/**
	 * Passing the User object to be used by "pages/result.html" - to read and
	 * display data entered by the user Using RedirectAttributes pass User object
	 * data to the "pages/results"
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String processFormData(User user, RedirectAttributes attr) {

		// Assuming we enter the submitted data to the DB. After that calling the
		// redirect function

		attr.addFlashAttribute("user", user);
		return "redirect:/display";
	}

	@RequestMapping(value = "display", method = RequestMethod.GET)
	public String displaySubmittedData(User user) {
		return "pages/results";
	}
}
