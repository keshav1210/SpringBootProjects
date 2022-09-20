package org.practice.project.repository;

import java.util.List;

import org.practice.project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer>{


	List<Product> getProductByCategoryId(int id);

}
