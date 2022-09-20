package org.practice.project.Controller;

import java.util.Optional;

import org.practice.project.entity.Category;
import org.practice.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/admin/categories")
	public ModelAndView getCategories(Model model) {
		model.addAttribute("categories", categoryService.getCategory());
		return new ModelAndView("categories");
		
	}

@GetMapping("/admin/categories/add")
public ModelAndView addCategories(Model model) { 
ModelAndView mv=new ModelAndView("categoriesAdd");
	Category category=new Category();
	model.addAttribute("category",  category);
	return mv;	
}
@PostMapping("/admin/categories/add")
public String addCategory(@ModelAttribute("category") Category category,Model model) {
	categoryService.addCategdory(category);
	model.addAttribute("categories", categoryService.getCategory());
	return  "redirect:/admin/categories";
	
}
@GetMapping("/admin/categories/update/{id}")
public String getupdateCategory(@PathVariable int id,  Model model) {
	
   Optional<Category> category=categoryService.getCategoryById(id);
	model.addAttribute("category", category.get());
	return "categoriesAdd";
			
	
}

@GetMapping("/admin/categories/delete/{id}")
public String  deletecategory(@PathVariable(value="id") int id) {
	categoryService.deleteaCatrgory(id);
	return "redirect:/admin/categories";
}

}
