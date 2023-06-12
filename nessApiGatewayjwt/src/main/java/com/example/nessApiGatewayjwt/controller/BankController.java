package com.example.nessApiGatewayjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nessApiGatewayjwt.model.Banks;
import com.example.nessApiGatewayjwt.service.UserService;
import com.example.nessApiGatewayjwt.util.JwtUtil;
@CrossOrigin
@RestController
@RequestMapping("bank")
public class BankController {
	@Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    
    @GetMapping("{email}")
    public ResponseEntity<Boolean> findBankDetailsByEmailAndAccountNo(@RequestBody Banks bank, @PathVariable String email){
    	String bankName=bank.getBankName();
    	long accountN0=bank.getAccoutNo();
    	boolean result=userService.findBankByEmailAndAccountNo(email, bankName, accountN0);
    	return new ResponseEntity<Boolean>(result,HttpStatus.OK);
    }
    
}
