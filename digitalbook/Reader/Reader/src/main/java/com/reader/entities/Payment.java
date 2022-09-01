package com.reader.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String readerEmail;
	private int bookId;
	private double bookPrice;
	private String purchaseDate = LocalDate.now().toString();

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int id, String readerEmail, int bookId, double bookPrice, String purchaseDate) {
		super();
		this.id = id;
		this.readerEmail = readerEmail;
		this.bookId = bookId;
		this.bookPrice = bookPrice;
		this.purchaseDate = purchaseDate;
	}

	public Payment(String readerEmail, int bookId, double bookPrice, String purchaseDate) {
		super();
		this.readerEmail = readerEmail;
		this.bookId = bookId;
		this.bookPrice = bookPrice;
		this.purchaseDate = purchaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getreaderEmail() {
		return readerEmail;
	}

	public void setreaderEmail(String readerEmail) {
		this.readerEmail = readerEmail;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", readerEmail=" + readerEmail + ", bookId=" + bookId + ", bookPrice=" + bookPrice
				+ ", purchaseDate=" + purchaseDate + "]";
	}

}
