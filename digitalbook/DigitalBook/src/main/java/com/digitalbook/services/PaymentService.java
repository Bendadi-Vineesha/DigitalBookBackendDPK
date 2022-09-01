package com.digitalbook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbook.entities.Payment;
import com.digitalbook.repositories.PaymentRepository;


@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepo;
	
	public List<Payment> findAllPayment() {
		return paymentRepo.findAll();
	}
	
	public Payment savePayment(Payment payment) {
		return paymentRepo.save(payment);
	}
	
	public Payment updatePayment(Payment payment) {
		
//		Book dbBook = paymentRepo.save(book);
		
		return paymentRepo.save(payment);
	}
	
	public Payment findById(int paymentId) {
		Optional<Payment> isPaymentAvailable = paymentRepo.findById(paymentId);
		if (isPaymentAvailable.isEmpty()) {
			throw new RuntimeException("Could not find Payment with Id : " + paymentId);
		} else {
			return isPaymentAvailable.get();
		}
	}
	
	
	public List<Payment> findPaymentByReaderEmail(String readerEmail){
		return paymentRepo.findByReaderEmail(readerEmail);
	}
	
	
	

}
