package com.example.product.ProductCart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.ProductCart.model.Cart;
import com.example.product.ProductCart.model.Transaction;
import com.example.product.ProductCart.model.User;

@Service
public interface UserService{
	public boolean buyProducts(List<Cart> cart, String email, String currencySpent);

	public User updateTransactions(Transaction transaction, String email);
	public List<Cart> addToCart(Cart cart,String email);
	public Transaction purchase(String email,String currency, double ForexAmount);

	int deductFromWallet(String userEmail, double amount);
	public List<Cart> viewCart(String email);
}
