package com.digitalbook.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String category;
	private int authorId;
	private double price;
	private boolean active;
	private String content;
	private String releaseDate;
	private String publisher;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	// Constructor
	public Book(int id, String title, String category, int authorId, double price, boolean active, String content,
			String releaseDate, String publisher) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.authorId = authorId;
		this.price = price;
		this.active = active;
		this.content = content;
		this.releaseDate = releaseDate;
		this.publisher = publisher;
	}
	
	public Book(String title, String category, int authorId, double price, boolean active, String content,
			String releaseDate, String publisher) {
		this.title = title;
		this.category = category;
		this.authorId = authorId;
		this.price = price;
		this.active = active;
		this.content = content;
		this.releaseDate = releaseDate;
		this.publisher = publisher;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Book(String category, int authorId, double price, String publisher) {
		this.category = category;
		this.authorId = authorId;
		this.price = price;
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", category=" + category + ", authorId=" + authorId + ", price="
				+ price + ", active=" + active + ", content=" + content + ", releaseDate=" + releaseDate
			 	+ ", publisher=" + publisher + "]";
	}
	
	// to String
	
	 
	
}
