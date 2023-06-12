package com.example.product.ProductCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.ProductCart.model.Book;
import com.example.product.ProductCart.repo.BookRepo;
@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookRepo bookRepo;
	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		
		return bookRepo.save(book);
	}
	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

}
