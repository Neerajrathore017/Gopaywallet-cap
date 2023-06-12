package com.example.forex.transaction.service.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {
	
	private double bookPrice;
	private String BookCatagory;
	private String bookName;
	private String bookImage;
	private String bookDetails;
	private double clothPrice;
	private String clothCatagory;
	private String	clothName;
	private String clothImage;
	//private String clothDetai
}
