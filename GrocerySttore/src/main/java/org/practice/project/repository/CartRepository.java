package org.practice.project.repository;

import org.practice.project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Product, Integer> {

}
