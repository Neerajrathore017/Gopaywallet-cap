package com.example.forex.transaction.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.forex.transaction.service.model.Banks;
import com.example.forex.transaction.service.service.UserService;



@CrossOrigin
@RestController
@RequestMapping("bank")
@ResponseBody
public class BankController {

	@Autowired
    UserService userService;
    
    @PostMapping("/{email:.+}")
    public ResponseEntity<Boolean> findBankDetailsByEmailAndAccountNo(@RequestBody Banks bank, @PathVariable String email){
    	String bankName=bank.getBankName();
    	System.out.println("accountNO--------"+bank);
    	int accountNo=bank.getAccoutNo();
    	boolean result=userService.findBankByEmailAndAccountNo(email, bank.getBankName(), bank.getAccoutNo());
    	return new ResponseEntity<Boolean>(result,HttpStatus.OK);
    }
    
}
