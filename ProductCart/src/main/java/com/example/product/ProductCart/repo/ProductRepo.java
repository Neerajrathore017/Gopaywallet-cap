package com.example.product.ProductCart.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.product.ProductCart.model.Product;

@Repository
public interface ProductRepo extends MongoRepository<Product,String> {
	Product findByType(String type);
	
}
