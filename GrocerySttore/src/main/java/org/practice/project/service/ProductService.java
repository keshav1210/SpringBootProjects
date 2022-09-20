package org.practice.project.service;

import java.util.List;
import java.util.Optional;

import org.practice.project.entity.Product;
import org.practice.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product>getProducts(){
		return productRepository.findAll() ;
		
	}

	public void addProduct(Product product) {
		productRepository.save(product);
		
	}

	public Product updateProductsById(int id, Product product2) {
		Product product =new Product();
		Product updatedProduct=null;
		
	   Optional<Product>oldProduct=productRepository.findById(id);
	   if(oldProduct.isPresent()) {
		   updatedProduct=oldProduct.get();
		   updatedProduct.setName(product.getName());
		   updatedProduct.setCategory(product.getCategory());
		   updatedProduct.setPrice(product.getPrice());
		   updatedProduct.setWeight(product.getWeight());
		   updatedProduct.setDescription(product.getDescription());
	   }
	   new Product();
		return productRepository.save(updatedProduct);
	}

	public Optional<Product> getProductsById(int id) {
			return productRepository.findById(id);
	}

	public void deleteProductById(int id) {
		productRepository.deleteById(id);
		
	}

	public List<Product> getProductsBYCategory(int id) {
		return productRepository.getProductByCategoryId(id);
		
	}

	
}
