package com.digitalbook.controllers;

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

import com.digitalbook.entities.Author;
import com.digitalbook.entities.Book;
import com.digitalbook.services.AuthorService;
import com.digitalbook.services.BookService;


@RestController
@CrossOrigin(origins = {"https://hoppscotch.io/"})
@RequestMapping("/api/v1/digitalbooks/author")
public class AuthorsController {

	@Autowired
	AuthorService authorService;
	
	@Autowired
	BookService bookService;
	
	
	@GetMapping("/fetch-all-author")
	public List<Author> fetchAllAuthor(){
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
	
	
	@PostMapping("/{authorid}/books")
	public Book createBook(@PathVariable int authorid, @RequestBody Book book) {
		book.setAuthorId(authorid);
		
		return bookService.saveBook(book);
	}
	
	@GetMapping("/{authorid}/books")
	public List<Book> createBook(@PathVariable int authorid) {
		
		return bookService.findBookByAuthorId(authorid);
	}
	
	@PutMapping("/{authorid}/books/{bookid}")
	public Book updateBook(@PathVariable int authorId,@PathVariable int bookid,@RequestBody Book book) {
		book.setAuthorId(authorId);
		book.setId(bookid);
		return bookService.updateBook(book);
	}
	
	
}
