package com.reader.contollers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reader.clients.BookClient;
import com.reader.clients.PaymentClient;
import com.reader.entities.Book;
import com.reader.entities.Payment;



@RestController
@RequestMapping("api/v1/reader/{readerEmail}")
public class ReaderController {
	
	@Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;
	
	private static final String TOPIC = "test-topic";
	
	
	@GetMapping("")
	public String book() {
		return "Hello Reader";
	}
	
	@Autowired
	BookClient bookClient;
	
	@Autowired
	PaymentClient paymentClient;
	
	
	/**
	 * Get all the purchase Book list by a reader email
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping("/books")
	public List<Book> getPurchasedBook(@PathVariable String readerEmail) {

		List<Payment> payment = paymentClient.getAllPaymentForSingleReader(readerEmail);
		List<Book> book = new ArrayList<>();
		
		Book tempBook = new Book();
		
		for (Payment p : payment) {
			if(bookClient.getBook(p.getBookId()).isActive())
				tempBook = bookClient.getBook(p.getBookId());
				tempBook.setReleaseDate(p.getPurchaseDate());
				book.add(tempBook);
		}

		return book;
	}
	
	
	/**
	 * Get all the purchase Book list which is block by author of the book
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping("/blocked-books")
	public List<Book> getPurchasedBookWhichIsBlocked(@PathVariable String readerEmail) {

		List<Payment> payment = paymentClient.getAllPaymentForSingleReader(readerEmail);
		List<Book> book = new ArrayList<>();
		for (Payment p : payment) {
			if(!bookClient.getBook(p.getBookId()).isActive())
				book.add(bookClient.getBook(p.getBookId()));
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

		System.out.println("Saving payment=====");
		Book book = bookClient.getBook(bookId);
		
		/*
		 *  Kafka Implimintation
		 */
//		System.out.println("=====Started Kafka=======");
//		kafkaTemplate.send(TOPIC, new Payment(readerEmail, book.getId(), book.getPrice(), LocalDate.now().toString()));
//		System.out.println("=====Ended Kafka=======");
//		return "Payment Done";
		
		/*
		 * Ending 
		 */
		
		
		Payment payment = new Payment(readerEmail, book.getId(), book.getPrice(), LocalDate.now().toString());
		return paymentClient.makePayment(payment);
		
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

		List<Payment> payment = paymentClient.getAllPaymentForSingleReader(readerEmail);
		for (Payment p : payment) {
			if (p.getBookId() == bookid) {
				isBookAvailableForReader = true;
				break;
			}
		}

		if (!isBookAvailableForReader) {
			throw new RuntimeException("You have not purchased subscription for this book");
		}
		return bookClient.getBook(bookid);
	}

	/**
	 * Get Book Details by Payment Id
	 * 
	 * @param paymentId
	 * @return
	 */
	@GetMapping("/books/{paymentId}")
	public Book getBookByPurchaseId(@PathVariable   int paymentId) {

		return bookClient.getBook(paymentClient.getPaymentByPaymentId(paymentId).getBookId());
	}

//	/**
//	 * 
//	 * @param bookid
//	 * @return
//	 */
//	@PostMapping("/books/{bookid}/refund")
//	public Book getBookRefund(@PathVariable int bookid) {
//
//		return null;
//	}
}
