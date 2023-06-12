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
public class Product {
	@Id
	private String type;
	private List<Book> books;
	private List<Cloth> cloths;
	//private List<Cart> cart;
	
}
