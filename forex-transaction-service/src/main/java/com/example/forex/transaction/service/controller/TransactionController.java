package com.example.forex.transaction.service.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.forex.transaction.service.model.Transaction;
import com.example.forex.transaction.service.model.User;
import com.example.forex.transaction.service.service.UserService;


@CrossOrigin
@RestController

@RequestMapping("transaction")
public class TransactionController {
	 
		@Autowired
	    UserService userService;
	    
	    @PutMapping("/{email:.+}")
	    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction, @PathVariable String email){
	    	Transaction user=userService.updateTransactions(transaction, email);
	    	return new ResponseEntity<Transaction>(user,HttpStatus.OK);
	    }

	    
	    
	    @GetMapping("/{email:.+}")
	    public ResponseEntity<List<Transaction>> findAllTransactions(@PathVariable String email){
	    	
	    	List<Transaction> transactions= userService.findAllTransactions(email);
	    
	    	return new ResponseEntity<List<Transaction>>(transactions,HttpStatus.OK);
	    }

	    

	    
}
