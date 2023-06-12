package com.example.product.ProductCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.ProductCart.model.Book;
import com.example.product.ProductCart.service.BookService;
import com.example.product.ProductCart.service.BookServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("book")
public class BookController {
	@Autowired
	BookService bookService;
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.saveBook(book),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Book>> findAllBooks(){
		return new ResponseEntity<List<Book>>(bookService.findAllBooks(),HttpStatus.OK);
	}

}
