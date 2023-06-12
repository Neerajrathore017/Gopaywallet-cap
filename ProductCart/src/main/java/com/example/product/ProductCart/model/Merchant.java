package com.example.product.ProductCart.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Merchant {
	@Id
	private String email;
	private String password;
	private String bankName;
	private double balance;
	//private List<Product> products;
	

}
