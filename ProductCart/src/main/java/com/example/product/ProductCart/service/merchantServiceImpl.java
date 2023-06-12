package com.example.product.ProductCart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.ProductCart.model.Merchant;
import com.example.product.ProductCart.repo.MerchantRepo;

@Service
	public class merchantServiceImpl implements MerchantService{
	@Autowired
	MerchantRepo merchantRepo;
	@Override
	public Merchant merchantLogin(String email, String password) {
		// TODO Auto-generated method stub
		Merchant merchant=merchantRepo.findByEmail(email);
		if(merchant.getPassword().equals(password)) {
			return merchant;
		}
		return null;
	}
	@Override
	public Merchant addMerchant(Merchant merchant) {
		// TODO Auto-generated method stub
		merchantRepo.save(merchant);
		return merchant;
	}
	@Override
	public double viewBalance(String email) {
		// TODO Auto-generated method stub
		Merchant merchant=merchantRepo.findByEmail(email);
		double balance=merchant.getBalance();
		return balance;
	}

}
