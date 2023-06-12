package com.example.nessApiGatewayjwt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nessApiGatewayjwt.model.Transaction;
import com.example.nessApiGatewayjwt.model.User;
import com.example.nessApiGatewayjwt.service.UserService;
import com.example.nessApiGatewayjwt.util.JwtUtil;
@CrossOrigin
@RestController

@RequestMapping("transaction")
public class TransactionController {
	 
		@Autowired
	    UserService userService;
	    
	    @PutMapping("/{email:.+}")
	    public ResponseEntity<User> updateTransaction(@RequestBody Transaction transaction, @PathVariable String email){
	    	User user=userService.updateTransactions(transaction, email);
	    	return new ResponseEntity<User>(user,HttpStatus.OK);
	    }

	    
	    
//	    @GetMapping("/{email:.+}")
//	    public ArrayList<String> findAllTransactions(@PathVariable String email){
//	    	
//	    	List<Transaction> transactions= userService.findAllTransactions(email);
//	    	
//	    	System.out.println("controller :"+transactions);
//	    
//	    	
//	    ArrayList<Transaction> trans=new ArrayList<>();
//	   
//	    //trans.add(new Transaction("11",2000, "10", "10-10-2010"));
//	    	
//	    ArrayList<String> data= new ArrayList<String>();
//	   // data.add("hello");
//	    	return data;
//	    
//	    
//	    }
//
//	    
//	    @GetMapping("test/{email:.+}")
//	    public ResponseEntity<String> findAllTransactionsTEST(@PathVariable String email){
//	    	
//	    	List<Transaction> trans=new ArrayList<>();
//	    	trans.add(new Transaction("aa",1,"aa","aa"));
//	    	return new ResponseEntity<List<Transaction>>(trans,HttpStatus.OK);
//	    
//	    	return new ResponseEntity<String>("hello",HttpStatus.OK);
//		    
//	    }

	    
}
