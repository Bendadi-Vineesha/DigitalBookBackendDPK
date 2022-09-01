package com.author.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.author.entites.Book;

@FeignClient(value = "bookFeignClient", url = "http://localhost:9090/api/v1/book")
public interface BookClients {
	
	@GetMapping("/{bookId}")
	public Book getBook(@PathVariable int bookId);
	
	@PostMapping("/{authorId}")
	public Book createBook(@PathVariable int authorId, @RequestBody Book book);
	
	@GetMapping("/author/{authorId}")
	public List<Book> getBookByAuthorId(@PathVariable int authorId);
	
	@PutMapping("/{authorId}")
	public Book updateBook(@PathVariable int authorId, @RequestBody Book book);
}
