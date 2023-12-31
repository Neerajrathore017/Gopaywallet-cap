package com.example.forex.transaction.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forex.transaction.service.exception.InsufficientBalanceException;
import com.example.forex.transaction.service.service.UserService;


@CrossOrigin
@RestController
@RequestMapping("wallet")
public class ForexCardController {

	@Autowired
    UserService userService;
    
    @PutMapping("{email}/{amount}")
    public ResponseEntity<Boolean> addMoneyToWallet(@PathVariable String email, @PathVariable double amount) throws InsufficientBalanceException{
    	boolean b=userService.addMoneyToWallet(amount, email);
    	return new ResponseEntity<Boolean>(b,HttpStatus.OK);
    }
    @GetMapping("/{email:.+}")
    public ResponseEntity<String> findWalletBalance(@PathVariable String email){
 
    	System.out.println(email);
    	//email=email+".com";
    	double money = userService.findWalletBalance(email);
    	System.out.println(money);

    	
    	return new ResponseEntity<String>(money+"",HttpStatus.OK);
    }

}
