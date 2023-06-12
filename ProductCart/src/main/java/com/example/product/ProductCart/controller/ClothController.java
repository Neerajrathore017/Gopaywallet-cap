package com.example.product.ProductCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.ProductCart.model.Book;
import com.example.product.ProductCart.model.Cloth;
import com.example.product.ProductCart.service.BookService;
import com.example.product.ProductCart.service.ClothService;

@RestController
@CrossOrigin
@RequestMapping("cloth")
public class ClothController {
	@Autowired
	ClothService clothService;
	
	@PostMapping
	public ResponseEntity<Cloth> saveCloth(@RequestBody Cloth cloth){
		return new ResponseEntity<Cloth>(clothService.saveCloth(cloth),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Cloth>> findAllClothes(){
		return new ResponseEntity<List<Cloth>>(clothService.findAllClothes(),HttpStatus.OK);
	}
}
