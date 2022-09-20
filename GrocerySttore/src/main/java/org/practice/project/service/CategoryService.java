package org.practice.project.service;

import java.util.List;
import java.util.Optional;

import org.practice.project.entity.Category;
import org.practice.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
@Autowired
private CategoryRepository categoryRepo;
public List<Category>getCategory(){
	return categoryRepo.findAll();
	
}
public Optional<Category> getCategoryById(int id) {
	return categoryRepo.findById(id);
}
public void addCategdory(Category category) {
	categoryRepo.save(category);
	
}
public Category updateaCategory(Category category,int id){
	Category updatedCategory=null;
	Optional<Category>oldCategory=categoryRepo.findById(id);
	if(oldCategory.isPresent()) {
		updatedCategory=oldCategory.get();
		updatedCategory.setName(category.getName());
	
	}
	new Category();
	return categoryRepo.save(updatedCategory);
}


public void deleteaCatrgory(int id) {
	categoryRepo.deleteById(id);
}
}