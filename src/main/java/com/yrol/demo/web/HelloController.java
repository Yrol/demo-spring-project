package com.yrol.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "greeting")
public class HelloController {

	/**
	 * using @RequestMapping annotation to specify the request type i.e. GET, POST,
	 * DELETE & etc
	 */
	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public String sayHello() {
		return "<h1>hello world</h1>";
	}

	/**
	 * As above GET isn't specified since by default RequestMapping is GET
	 */
	@RequestMapping("/proper")
	public String sayProperHello() {
		return "<h1>Hello there how are you?</h1>";
	}

	/**
	 * For demo only - including an HTML form isn't a good practice Can also be
	 * Submitted as a POST request as well and receiving method (user_greeting) should also accept POST
	 */
	@RequestMapping("/submit_name_post")
	public String userFormPost() {
		return " <form action=\"user_greeting_post\" method=\"POST\">\n" + "  <label for=\"fname\">First name:</label><br>\n"
				+ "  <input type=\"text\" id=\"fname\" name=\"fname\"><br>\n"
				+ "  <label for=\"lname\">Last name:</label><br>\n"
				+ "  <input type=\"text\" id=\"lname\" name=\"lname\"><br><br>\n"
				+ "  <input type=\"submit\" value=\"Submit\">\n" + "</form> ";
	}

	/**
	 * Using the @RequestParam annotation to pass the values coming from the form
	 * POST Example
	 * above in userForm Func
	 */
	@RequestMapping(value = "/user_greeting_post", method = RequestMethod.POST)
	public String printUserGreetingPost(@RequestParam String fname, @RequestParam String lname) {
		return "Hello there," + fname + " " + lname;
	}
	
	
	/**
	 * For demo only - including an HTML form isn't a good practice Can also be
	 * Submitted as a GET request as well and receiving method (user_greeting) should also accept GET
	 */
	@RequestMapping("submit_name_get")
	public String userFormGet() {
		return " <form action=\"user_greeting_get\" method=\"GET\">\n" + "  <label for=\"fname\">First name:</label><br>\n"
				+ "  <input type=\"text\" id=\"fname\" name=\"fname\"><br>\n"
				+ "  <label for=\"lname\">Last name:</label><br>\n"
				+ "  <input type=\"text\" id=\"lname\" name=\"lname\"><br><br>\n"
				+ "  <input type=\"submit\" value=\"Submit\">\n" + "</form> ";
	}
	
	
	@RequestMapping(value = "/user_greeting_get")
	public String printUserGreetingGet(@RequestParam String fname, @RequestParam String lname) {
		return "Hello there," + fname + " " + lname;
	}
	

	/**
	 * Dynamic URLs using @PathVariable annotation
	 * 
	 * @PathVariable will be used for defining path variables which is a part of URL
	 */
	@RequestMapping("/product/{id}")
	public String getProduct(@PathVariable String id) {
		return "Product ID: " + id;
	}

	/**
	 * Dynamic URLs using @PathVariable annotation Similar to above example and
	 * Treating and handling @PathVariable as optional
	 */
	@RequestMapping(value = { "/order", "/order/{id}" })
	public String getOrder(@PathVariable(required = false) String orderId) {
		if (orderId != null) {
			return "Order ID: " + orderId;
		}
		return "No order ID is defined";
	}
}