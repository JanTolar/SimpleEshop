package cz.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cz.eshop.service.ProductService;

@Controller
public class MainController {

	@Autowired
	ProductService productService;

	/**
	 * Method returns main page.
	 */
	@GetMapping( { "/", "/index" } )
	public String index() {

		return "index";
	}

}