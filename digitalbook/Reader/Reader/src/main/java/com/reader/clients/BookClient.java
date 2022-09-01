package com.reader.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.reader.entities.Book;


@FeignClient(value = "bookClient", url = "http://localhost:9090/api/v1/book")
public interface BookClient {

	@GetMapping("/{bookId}")
	public Book getBook(@PathVariable int bookId);
	
	@GetMapping("/fetch-all-blockedbook")
	public List<Book> getAllBlockedBook();
	
	@PostMapping("/{authorId}")
	public Book createBook(@PathVariable int authorId, @RequestBody Book book);
	
	@PutMapping("/{authorId}")
	public Book updateBook(@PathVariable int authorId, @RequestBody Book book);
}
