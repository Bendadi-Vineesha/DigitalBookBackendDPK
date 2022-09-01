package com.payment.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.payment.entities.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	public List<Payment> findByReaderEmail(String readerEmail);
	
	public List<Payment> findByReaderEmailAndBookId(String readerEmail, int bookId);
	
//	@Query("DELETE FROM payment p WHERE p.reader_email = :reader_email and p.book_id = :book_id")
//	public void deleteByReaderEmailAndBookId(@Param("reader_email")String readerEmail, @Param("book_id")int bookId); 
}
