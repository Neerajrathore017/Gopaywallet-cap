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
public class Cloth {
	@Id
	private String	clothName;
	private double clothPrice;
	private String clothCatagory;
	private String clothImage;
	private String clothMerchantEmail;
	//private String clothDetails;
}
