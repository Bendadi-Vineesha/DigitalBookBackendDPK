package com.digitalbook.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.entities.Book;
import com.digitalbook.entities.Reader;
import com.digitalbook.repositories.BookRepository;

@RestController
@CrossOrigin(origins = {"https://hoppscotch.io/"})
@RequestMapping("/api/v1/digitalbooks/books")
public class BookController {

	@Autowired
	BookRepository bookRepo;

	@GetMapping("search")
	public List<Book> searchBook(@PathParam(value = "category") String category,@PathParam(value = "author") int author, 
			@PathParam(value = "price") double price, @PathParam(value = "publisher") String publisher){
		
		return bookRepo.findByCategoryOrPublisherOrAuthorIdOrPrice(category, publisher, author, price);

	}
	
	
	@GetMapping("fetch-all-book")
	public List<Book> fetchAllBook() {
		return bookRepo.findAll();
	}
}
