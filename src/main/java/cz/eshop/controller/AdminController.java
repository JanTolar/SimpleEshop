package cz.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cz.eshop.entity.Product;
import cz.eshop.service.ProductService;

@Controller
public class AdminController {

	private static final String ADMIN_PATH_PREFIX = "admin/";

	@Autowired
	ProductService productService;

	/**
	 * Method loads products and returns Product admin page.
	 */
	@GetMapping("admin/products")
	public String index(Model model) {

		List<Product> products = productService.getList();
		model.addAttribute("products", products);

		return ADMIN_PATH_PREFIX + "products_list";
	}

	/**
	 * Method prepares and returns edit Product form.
	 */
	@GetMapping("admin/edit_product_{id}")
	public String editProduct(
			@PathVariable("id") Long productId, 
			Model model) {

		Product product = productService.loadById(productId);
		model.addAttribute("product", product);

		return ADMIN_PATH_PREFIX + "product_admin";
	}

	/**
	 * Method handling POST request for updating Product in DB
	 */
	@PostMapping("admin/edit_product_{id}")
	public String updateProduct(
			@ModelAttribute("product") Product product,
			Model model) {

		productService.update(product);

		return "redirect:products";

	}

}
