package com.example.product.ProductCart.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
	@Id
	private String bookName;
	private double bookPrice;
	private String BookCatagory;

	private String bookImage;
	private String bookDetails;
	private String bookMerchantEmail;
}
