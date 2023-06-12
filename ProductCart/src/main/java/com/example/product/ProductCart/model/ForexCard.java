package com.example.product.ProductCart.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForexCard {
	private String bankName;
	private String walleId;
	private double balance;
	private String currency;
	private List<Transaction> transactions;
	
	//private String dateOfTransaction;
	

}
