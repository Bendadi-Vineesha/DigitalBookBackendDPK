package com.reader.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reader.entities.Payment;

@FeignClient(value = "paymentClient", url = "http://localhost:9090/api/v1/payment")
public interface PaymentClient {
	
	@PostMapping("/makePayment")
	public Payment makePayment(Payment p);
	
	@GetMapping("/all-payment/{readerEmail}")
	public List<Payment> getAllPaymentForSingleReader(@PathVariable String readerEmail);
	
	@GetMapping("/{paymentId}")
	public Payment getPaymentByPaymentId(@PathVariable int paymentId);

}
