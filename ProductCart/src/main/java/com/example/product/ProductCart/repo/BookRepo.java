package com.example.product.ProductCart.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.product.ProductCart.model.Book;
@Repository
public interface BookRepo extends MongoRepository<Book, String> {
	
}
