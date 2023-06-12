package com.example.product.ProductCart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.ProductCart.model.Book;

@Service
public interface BookService {
	public Book saveBook(Book book);
	public List<Book> findAllBooks();
}
