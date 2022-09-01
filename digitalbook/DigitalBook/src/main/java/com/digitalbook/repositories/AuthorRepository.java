package com.digitalbook.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbook.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	public Optional<Author> findAuthorByAuthorEmail(String authorEmail);
	
	public Optional<Author> findAuthorByAuthorEmailAndAuthorPass(String authorEmail, String authorPass);
}
