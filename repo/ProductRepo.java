package org.se.lab1.repo;

import org.se.lab1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Product deleteProductById(Long id);
}
