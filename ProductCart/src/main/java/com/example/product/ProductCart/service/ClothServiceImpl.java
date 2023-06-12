package com.example.product.ProductCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.ProductCart.model.Cloth;
import com.example.product.ProductCart.repo.ClothRepo;
@Service
public class ClothServiceImpl implements ClothService{
	@Autowired
	ClothRepo clothRepo;
	@Override
	public Cloth saveCloth(Cloth cloth) {
		// TODO Auto-generated method stub
		return clothRepo.save(cloth);
	}
	@Override
	public List<Cloth> findAllClothes() {
		// TODO Auto-generated method stub
		return clothRepo.findAll();
	}

}
