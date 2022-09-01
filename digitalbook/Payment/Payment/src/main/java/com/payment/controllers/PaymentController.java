package com.payment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entities.Payment;
import com.payment.services.PaymentService;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

	@GetMapping
	public String book() {
		return "Hello Payment";
	}

	@Autowired
	PaymentService paymentService;

	@PostMapping("/makePayment")
	public Payment makePayment(@RequestBody Payment p) {
		return paymentService.savePayment(p);
	}

	@GetMapping("/fetch-all-payment")
	public List<Payment> getAllPaymentList() {
		return paymentService.findAllPayment();
	}

	@GetMapping("/{paymentId}")
	public Payment getPaymentByPaymentId(@PathVariable int paymentId) {
		return paymentService.findById(paymentId);
	}

	@GetMapping("/all-payment/{readerEmail}")
	public List<Payment> getAllPaymentForSingleReader(@PathVariable String readerEmail) {
		return paymentService.findPaymentByReaderEmail(readerEmail);
	}

	@DeleteMapping("/{readerEmail}/unsubscribe/{bookId}")
	public Payment unSubscribeBook(@PathVariable String readerEmail, @PathVariable int bookId) {
		try {
			paymentService.deleteByReaderEmailAndBookId(readerEmail, bookId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Could not Unsubscribe Book  : ");
		}
		return new Payment();
	}
}
