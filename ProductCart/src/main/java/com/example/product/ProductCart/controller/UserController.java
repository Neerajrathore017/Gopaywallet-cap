package com.example.product.ProductCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.ProductCart.model.Cart;
import com.example.product.ProductCart.model.Merchant;
import com.example.product.ProductCart.model.Transaction;
import com.example.product.ProductCart.repo.UserRepository;
import com.example.product.ProductCart.service.MerchantService;
import com.example.product.ProductCart.service.UserService;
@RestController
@CrossOrigin
@RequestMapping("product/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	MerchantService merchantService;
	@PostMapping("cart/{email}")
	public ResponseEntity<List<Cart>> addToCart(@RequestBody Cart cart,@PathVariable String email){
		return new ResponseEntity<List<Cart>>(userService.addToCart(cart, email),HttpStatus.OK);
	}
	@PutMapping("purchase/{email}/{currency}/{forexAmount}")
	public ResponseEntity<Transaction> purchase(@PathVariable String email, @PathVariable String currency, @PathVariable double forexAmount){
		Transaction trans=userService.purchase(email, currency, forexAmount);
		return new ResponseEntity<Transaction>(trans,HttpStatus.OK);
	}
	@PostMapping("merchant")
	public ResponseEntity<Merchant> addMerchant(@RequestBody Merchant merchant){
		return new ResponseEntity<Merchant>(merchantService.addMerchant(merchant),HttpStatus.OK);
	}
	@GetMapping("merchant/{email}/{password}")
	public ResponseEntity<Merchant> findMerchant(@PathVariable String email, @PathVariable String password){
		return new ResponseEntity<Merchant>(merchantService.merchantLogin(email, password),HttpStatus.OK);
	}
	@GetMapping("cart/{email}")
	public ResponseEntity<List<Cart>> viewCart(@PathVariable String email){
		List<Cart> cart=userService.viewCart(email);
		return new ResponseEntity<List<Cart>>(cart,HttpStatus.OK);
	}
	

}
