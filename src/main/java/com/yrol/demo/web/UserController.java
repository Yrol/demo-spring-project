package com.yrol.demo.web;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yrol.demo.domain.Product;

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

	/**
	 * Returning a list of String items
	 */
	@RequestMapping("/{userId}/products_as_string")
	public List<String> displayItems(@PathVariable int userId) {
		return Arrays.asList("Samsung Galaxy S4", "Redmi Note 5", "Sony");
	}

	/**
	 * Returning a list of custom object (Product) items as JSON
	 */
	@RequestMapping("/{userId}/products_as_json")
	public List<Product> displayProductsAsJson(@PathVariable int userId) {
		return Arrays.asList(new Product(1, "Samsung Galaxy S4", 599.00), new Product(2, "Redmi Note 5", 489.00),
				new Product(3, "Sony", 399.00));
	}
}
