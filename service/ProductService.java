package org.se.lab1.service;

import org.se.lab1.model.Product;
import org.se.lab1.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Product getProductById(long id) {
        return productRepo.findById(id).orElse(null);
    }
    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();
        for ( Product product : products) {
            System.out.println(product);
        }
        return products;
    }
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }
    public Product updateProduct(long id, Product product) {
        Product oldProduct = productRepo.findById(id).orElse(null);
        if(oldProduct != null) {
            oldProduct.setName(product.getName());
            oldProduct.setCategory(product.getCategory());
            oldProduct.setPrice(product.getPrice());
            productRepo.save(oldProduct);
        }
        return product;
    }
    public Product deleteProductById(long id) {
        Product product = productRepo.findById(id).orElse(null);
        if (product!=null) {
            productRepo.deleteById(id);
        }
        return product;
    }


}
