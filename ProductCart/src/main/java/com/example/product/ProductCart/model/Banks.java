package com.example.product.ProductCart.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class Banks {
	private String bankName;
	private int accoutNo;
	private double balance;
	

}
