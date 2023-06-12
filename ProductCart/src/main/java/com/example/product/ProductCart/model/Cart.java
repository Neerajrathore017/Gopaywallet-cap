package com.example.product.ProductCart.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {
	
	private double bookPrice;
	private String bookCatagory;
	private String bookName;
	private String bookImage;
	private String bookDetails;
	private String bookMerchantEmail;
	private double clothPrice;
	private String clothCatagory;
	private String	clothName;
	private String clothImage;
	private String clothMerchantEmail;
	//private String clothDetai
}
