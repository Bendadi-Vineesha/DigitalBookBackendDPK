package com.book.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entities.Book;
import com.book.services.BookService;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

	@GetMapping
	public String book() {
		return "Hello Book";
	}

	@Autowired
	BookService bookService;

//	@GetMapping("search")
//	public List<Book> searchBook(@PathParam(value = "category") String category,
//			@PathParam(value = "author") Integer author, @PathParam(value = "price") double price,
//			@PathParam(value = "publisher") String publisher) {
//		
//		Book b = new Book(category, author, price, publisher);
//		return bookService.searchBook(b);
//
//	}
	
	@GetMapping("search")
	public List<Book> searchBook(@PathParam(value = "title") String title) {
		
		return bookService.findBookByTitle(title);

	}

	
	/**
	 * Find a book by using Book Id
	 * 
	 * @param bookId
	 * @return
	 */
	@GetMapping("/{bookId}")
	public Book getBookById(@PathVariable int bookId) {

		return bookService.findById(bookId);

	}
	
	/**
	 * Find a List of book which is written by author using authorId
	 * 
	 * @param bookId
	 * @return
	 */
	@GetMapping("/author/{authorId}")
	public List<Book> getBookByAuthorId(@PathVariable int authorId) {

		return bookService.findBookByAuthorId(authorId);

	}

	/**
	 *  Create a Book by Auhtor
	 *  
	 * @param authorId
	 * @param book
	 * @return
	 */
	@PostMapping("/{authorId}")
	public Book createBook(@PathVariable int authorId, @RequestBody Book book) {
		book.setAuthorId(authorId);

		return bookService.saveBook(book);

	}
	
	
	@PutMapping("/{authorId}")
	public Book updateBook(@PathVariable int authorId,@RequestBody Book book) {
		
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/{bookId}")
	public Book deleteBook(@PathVariable int bookId) {
		
		try {
			bookService.deleteBook(bookId);
			return new Book();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			return new Book();
		}
	}

	@GetMapping("fetch-all-book")
	public List<Book> fetchAllBook() {
		return bookService.findAllBook();
	}
	@GetMapping("fetch-all-activebook")
	public List<Book> fetchAllActiveBook() {
//		return bookService.findAllBook();
		return bookService.findAllActiveBook();
	}
	
	@GetMapping("fetch-all-blockedbook")
	public List<Book> fetchAllBlockedBook() {
//		return bookService.findAllBook();
		return bookService.findAllInactiveBook();
	}
	
	
}
