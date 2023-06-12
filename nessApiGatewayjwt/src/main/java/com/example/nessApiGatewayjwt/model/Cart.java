package com.example.nessApiGatewayjwt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Cart {
	
	//private String email;
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
