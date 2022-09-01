package com.author.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.author.clients.BookClients;
import com.author.entites.Author;
import com.author.entites.Book;
import com.author.services.AuthorService;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

	@GetMapping("")
	public String author() {
		return "Hello Author";
	}
	
	@Autowired
	AuthorService authorService;
	
	@Autowired
	BookClients bookClients;
	
//	@Autowired
//	BookService bookService;
	
	
	@GetMapping("/fetch-all-author")
	public List<Author> fetchAllAuthor(){
		System.out.println("=====Request Coming =======");
		return authorService.findAllAuthor();
	}
	
	@PostMapping("/signup")
	public Author signup(@RequestBody Author author) {
		
		return authorService.signupAuthor(author);
	}
	
	@PostMapping("/login")
	public Author login(@RequestBody Author author) {
		
		return authorService.findAuthorByEmailAndPassWord(author.getAuthorEmail(), author.getAuthorPass());
	}
	
	/*
	 * Book Services 
	 */
	
	@GetMapping("/{bookId}")
	public Book gg(@PathVariable int bookId) {
		return bookClients.getBook(bookId);
	}

	/**
	 * Creating Book
	 * @param authorId
	 * @param book
	 * @return
	 */
	@PostMapping("/{authorEmail}/books")
	public Book createBook(@PathVariable String authorEmail, @RequestBody Book book) {
		Author author = authorService.findAuthorByEmail(authorEmail);
		
		book.setAuthorId(author.getAuthorId());
		
		return bookClients.createBook(author.getAuthorId(), book);
	}
	
	/**
	 * Getting Book which is written by Author
	 * @param authorId
	 * @param book
	 * @return
	 */
	@GetMapping("/{authorEmail}/books")
	public List<Book> getAuthorsBook(@PathVariable String authorEmail) {
		Author author = authorService.findAuthorByEmail(authorEmail);
		
//		return bookClients.createBook(author.getAuthorId(), book);
		return bookClients.getBookByAuthorId(author.getAuthorId());
	}

	
	@PutMapping("/{authorId}/books/{bookid}")
	public Book updateBook(@PathVariable int authorId,@PathVariable int bookid,@RequestBody Book book) {
		
		book.setId(bookid);
		return bookClients.updateBook(authorId , book);
	}
	
	
}
