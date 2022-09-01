package com.digitalbook.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbook.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	public List<Payment> findByReaderEmail(String readerEmail);
}
