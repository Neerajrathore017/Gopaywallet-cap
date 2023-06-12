package com.example.product.ProductCart.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	private boolean moneyStatus;
	private String currency="INR";
	private boolean transactionStatus;
	private String transactionId;
	private  double transactionAmountINR;
	private double transactionAmountForex;
	private  List<String> productName;
	private String date;
	

}
