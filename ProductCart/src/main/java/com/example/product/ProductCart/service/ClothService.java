package com.example.product.ProductCart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.ProductCart.model.Cloth;

@Service
public interface ClothService {
	public Cloth saveCloth(Cloth cloth);
	public List<Cloth> findAllClothes();
}
