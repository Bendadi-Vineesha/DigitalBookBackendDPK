package com.digitalbook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbook.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByTitle(String Title);
	
	public List<Book> findByCategory(String category);
	
	public List<Book> findByPrice(String price);
	
	public List<Book> findByPublisher(String publisher);
	
	public List<Book> findByAuthorId(int authorId);
	
	public List<Book> findByCategoryOrPublisherOrAuthorIdOrPrice(String category, String publisher, int authorId , double price);
}
