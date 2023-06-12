package com.example.forex.transaction.service.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String secQuestion;
	private String secAnswer;
	private String phoneNo;
	private List<Banks> bankList;
	 private ForexCard forexCard;
	 private List<Cart> userCart;
	 private int rewardPoints;
	 //private Transaction transactions;
	
}

