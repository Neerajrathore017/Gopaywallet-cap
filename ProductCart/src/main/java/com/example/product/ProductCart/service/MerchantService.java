package com.example.product.ProductCart.service;

import org.springframework.stereotype.Service;

import com.example.product.ProductCart.model.Merchant;

@Service
public interface MerchantService {
	public Merchant merchantLogin(String email, String password);
	public Merchant addMerchant(Merchant merchant);
	public double viewBalance(String email);
}
