package com.author.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.entites.Author;
import com.author.repositories.AuthorRepository;




@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepo;

	public Author signupAuthor(Author author) {
		try
		{
			findAuthorByEmail(author.getAuthorEmail());
		}catch(RuntimeException e) {
			return authorRepo.save(author);
		}
		throw new RuntimeException("Author already registered with this mail : " + author.getAuthorEmail());
		
	}
	
	public List<Author> findAllAuthor(){
		return authorRepo.findAll();
	}

	public Author findAuthorByEmail(String authorEmail) {
		Optional<Author> isAuthorAvailable = authorRepo.findAuthorByAuthorEmail(authorEmail);
		if (!isAuthorAvailable.isPresent()) {
			throw new RuntimeException("Could not find Author with email : " + authorEmail);
		} else {
			return isAuthorAvailable.get();
		}
	}
	
	public Author findAuthorByEmailAndPassWord(String email, String pass) {
		Optional<Author> isAuthorAvailable = authorRepo.findAuthorByAuthorEmailAndAuthorPass(email,pass);
		if (!isAuthorAvailable.isPresent()) {
			throw new RuntimeException("Could not find Valid Author with this email : " + email +" /nPlease check your Email and Password");
		} else {
			return isAuthorAvailable.get();
		}
	}
}
