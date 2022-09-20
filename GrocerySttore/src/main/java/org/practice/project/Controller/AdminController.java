package org.practice.project.Controller;

import org.practice.project.entity.Product;
import org.practice.project.global.GlobalData;
import org.practice.project.repository.CartRepository;
import org.practice.project.repository.ProductRepository;
import org.practice.project.service.CategoryService;
import org.practice.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {
@Autowired
private CategoryService categoryService;
@Autowired
private ProductService productService;
@Autowired
ProductRepository productRepository;
@Autowired
CartRepository cartRepository;
@GetMapping("/admin")
public String homeController() {
	
	return "adminHome";
}

@GetMapping("/")
public String indexController(Model model) {
	model.addAttribute("cartCount", GlobalData.cart.size());
	return "index";
}
@GetMapping("/shop")
public String shop(Model model) {
	model.addAttribute("products",productService.getProducts());
	model.addAttribute("categories",categoryService.getCategory());
	return "shop";
}
@GetMapping("/shop/category/{id}")
public String getProductsByCategoryId(@PathVariable("id")int id, Model model) {
	model.addAttribute("categories",categoryService.getCategory());
model.addAttribute("products",productService.getProductsBYCategory(id));

return "shop";
}
@GetMapping("shop/viewproduct/{id}")
public String viewProducts(@PathVariable("id") int id,Model model) {
	model.addAttribute("product", productService.getProductsById(id).get());
	return "viewProduct";
	
}


@GetMapping("/addToCart/{id}")
public String addToCart(@PathVariable("id") int id) {
GlobalData.cart.add(productService.getProductsById(id).get());
	return "redirect:/cart";
	
}
@GetMapping("/cart")
public String cart( Model model) {
	model.addAttribute("cartCount", GlobalData.cart.size());
	model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
	model.addAttribute("cart", GlobalData.cart);
	return"cart";
	
}
@GetMapping("/checkout")
public String checkout(Model model) {
	model.addAttribute("cartCount", GlobalData.cart.size());
	model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
	return "checkout";
}
@GetMapping("/cart/removeItem/{index}")
public String cartItemRemove(@PathVariable int index) {
	GlobalData.cart.remove(index);
	return "redirect:/cart";
}

}
