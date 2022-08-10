package com.yrol.demo.web;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@RequestMapping("/{id}")
	public String getUser(@PathVariable(name = "id") int userId) {
		return "User found: " + userId;
	}

	/**
	 * Using @PathVariable and @RequestParam in combination URL ex:
	 * [localhost:8080/user/24/invoices?invoice_date=01/03/2021] GET by default
	 * for @RequestParam
	 */
	@RequestMapping("/{userId}/invoices")
	public String displayUserInvoices(@PathVariable int userId,
			@RequestParam(name = "invoice_date", required = false) Date date) {
		return "Invoice found for user: " + userId + " for date: " + date;
	}
	
}
