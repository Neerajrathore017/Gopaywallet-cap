package com.example.product.ProductCart.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.product.ProductCart.model.Merchant;


@Repository
public interface MerchantRepo extends MongoRepository<Merchant,String> {
	public Merchant findByEmail(String email);
}
