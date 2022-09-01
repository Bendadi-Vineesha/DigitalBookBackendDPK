package com.digitalbook.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.entities.Book;
import com.digitalbook.entities.Payment;
import com.digitalbook.services.BookService;
import com.digitalbook.services.PaymentService;
import com.digitalbook.services.ReaderService;

@RestController
@CrossOrigin(origins = { "https://hoppscotch.io/" })
@RequestMapping("/api/v1/digitalbooks/readers/{readerEmail}/books")
public class ReadersController {

	@Autowired
	ReaderService readerService;

	@Autowired
	PaymentService paymentService;

	@Autowired
	BookService bookService;

	/**
	 * Get all the purchase Book list by a reader email
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping("")
	public List<Book> getPurchasedBook(@PathVariable String readerEmail) {

		List<Payment> payment = paymentService.findPaymentByReaderEmail(readerEmail);
		List<Book> book = new ArrayList<>();

		for (Payment p : payment) {
			book.add(bookService.findById(p.getBookId()));
		}

		return book;
	}

	/**
	 * Buying subscription for the book
	 * 
	 * @param readerEmail
	 * @param book
	 * @return
	 */
	@PostMapping("/{bookId}")
	public Payment getBookByPurchaseId(@PathVariable String readerEmail, @PathVariable int bookId) {

		System.out.println("Saving payment");
		Book book = bookService.findById(bookId);
		Payment payment = new Payment(readerEmail, book.getId(), book.getPrice(), LocalDate.now().toString());
		return paymentService.savePayment(payment);
	}

	/**
	 * Opening purchased book by reader.
	 * 
	 * @param email
	 * @param bookid
	 * @return
	 */
	@GetMapping("/{bookid}")
	public Book readPurchasedBook(@PathVariable String readerEmail, @PathVariable int bookid) {
		boolean isBookAvailableForReader = false;

		List<Payment> payment = paymentService.findPaymentByReaderEmail(readerEmail);
		for (Payment p : payment) {
			if (p.getBookId() == bookid) {
				isBookAvailableForReader = true;
				break;
			}
		}

		if (!isBookAvailableForReader) {
			throw new RuntimeException("You have not purchased subscription for this book");
		}
		return bookService.findById(bookid);
	}

	/**
	 * Get Book Details by Payment Id
	 * 
	 * @param paymentId
	 * @return
	 */
	@GetMapping("/books")
	public Book getBookByPurchaseId(@PathParam(value = "pid") int paymentId) {

		return bookService.findById(paymentService.findById(paymentId).getBookId());
	}

	/**
	 * 
	 * @param bookid
	 * @return
	 */
	@PostMapping("/books/{bookid}/refund")
	public Book getBookRefund(@PathVariable int bookid) {

		return null;
	}

}
