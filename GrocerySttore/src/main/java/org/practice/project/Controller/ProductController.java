package org.practice.project.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.practice.project.DTO.ProductDTO;
import org.practice.project.entity.Product;
import org.practice.project.service.CategoryService;
import org.practice.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {
	public static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/productImages";
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
@GetMapping("/admin/products")
public String getProduct(Model model) {
	
	model.addAttribute("products", productService.getProducts());
	
	return "products";
	
}
@GetMapping("/admin/products/add")
public String getAddedProducts( Model model) {
	
	ProductDTO productdto =new ProductDTO();
	model.addAttribute("productDTO",productdto );
	model.addAttribute("categories", categoryService.getCategory());
	return "productsAdd";
	
}
@PostMapping("/admin/products/add")
public String getaddProducts(@ModelAttribute("productDTO") ProductDTO productdto, @RequestParam("productImage") MultipartFile file,@RequestParam("imgName")String imgName)throws IOException {
	Product product=new Product();
	product.setId(productdto.getId());
	product.setName(productdto.getName());
	product.setPrice(productdto.getPrice());
	product.setDescription(productdto.getDescription());
	product.setCategory(categoryService.getCategoryById(productdto.getCategoryId()).get());
	product.setWeight(productdto.getWeight());
	String imgUid;
	if(!file.isEmpty()) {
		imgUid=file.getOriginalFilename();
		Path fileNameAndPath=Paths.get(uploadDir,imgUid);
		Files.write(fileNameAndPath, file.getBytes());
	}else {
		imgUid=imgName;
	}
	product.setImageName(imgUid);
	productService.addProduct(product);	
	return "redirect:/admin/products";

}
@GetMapping("/admin/product/update/{id}")
public String updateProjects( Model model,@PathVariable("id") int id) {
	Product products= productService.getProductsById(id).get();
	ProductDTO productdto=new ProductDTO();
	productdto.setId(products.getId());
	productdto.setName(products.getName());
	productdto.setCategoryId(products.getCategory().getId());
	productdto.setPrice(products.getPrice());
	productdto.setWeight(products.getWeight());
	productdto.setDescription(products.getDescription());
	productdto.setImageName(products.getImageName());
	model.addAttribute("categories", categoryService.getCategory());
	model.addAttribute("productDTO",productdto );
	return "productsAdd";
	
	
}
@GetMapping("/admin/product/delete/{id}")
public String deleteProduct(@PathVariable("id") int id) {
	productService.deleteProductById(id);
	return "redirect:/admin/products";
}
}
