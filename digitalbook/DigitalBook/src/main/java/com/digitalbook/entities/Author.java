package com.digitalbook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorId;
	private String authorName;
	private String authorEmail;
	private String authorPass;
	private String gender;
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public String getAuthorPass() {
		return authorPass;
	}
	public void setAuthorPass(String authorPass) {
		this.authorPass = authorPass;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Author(String authorName, String authorEmail, String authorPass, String gender) {

		this.authorName = authorName;
		this.authorEmail = authorEmail;
		this.authorPass = authorPass;
		this.gender = gender;
	}
	public Author() {
		
	}
	
	
}
