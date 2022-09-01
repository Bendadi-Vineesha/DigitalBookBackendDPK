package com.digitalbook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbook.entities.Author;
import com.digitalbook.entities.Book;
import com.digitalbook.repositories.BookRepository;

import net.bytebuddy.asm.Advice.Return;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> findAllBook() {
		return bookRepo.findAll();
	}
	
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book updateBook(Book book) {
		
		Book dbBook = bookRepo.save(book);
		
		if(book.getCategory() != null) {
			dbBook.setCategory(book.getCategory());
		}
		if(book.getContent() != null) {
			dbBook.setContent(book.getContent());
		}
		if(book.getPrice() > 0) {
			dbBook.setPrice(book.getPrice());
		}
		if(book.getPublisher() != null) {
			dbBook.setPublisher(book.getPublisher());
		}
		if(book.getReleaseDate() != null) {
			dbBook.setReleaseDate(book.getReleaseDate());
		}
		if(book.isActive() != dbBook.isActive()) {
			dbBook.setActive(book.isActive());
		}
		if(book.getTitle() != null) {
			dbBook.setTitle(book.getTitle());
		}
		
		return bookRepo.save(dbBook);
	}
	
	public Book findById(int bookId) {
		Optional<Book> isBookAvailable = bookRepo.findById(bookId);
		if (isBookAvailable.isEmpty()) {
			throw new RuntimeException("Could not find Book with Id : " + bookId);
		} else {
			return isBookAvailable.get();
		}
	}
	
	public List<Book> findBookByTitle(String bookTitle) {
		List<Book> isBookAvailable = bookRepo.findByTitle(bookTitle);
		if (isBookAvailable.size()==0) {
			throw new RuntimeException("Could not find book with Title: " + bookTitle);
		}
		return isBookAvailable;
	}
	
	public List<Book> findBookByAuthorId(int authorId){
		return bookRepo.findByAuthorId(authorId);
	}
	
	public List<Book> searchBook(Book book){
		
		return bookRepo.findByCategoryOrPublisherOrAuthorIdOrPrice(book.getCategory(), book.getPublisher(), book.getAuthorId(), book.getPrice());
	}

}
