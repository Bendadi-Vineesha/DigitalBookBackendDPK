package com.digitalbook.entities;

public class Reader {

	private int readerId;
	private String readerName;
	private String readerEmail;

	public Reader(int readerId, String readerName, String readerEmail) {
		this.readerId = readerId;
		this.readerName = readerName;
		this.readerEmail = readerEmail;
	}

	public Reader() {
		// TODO Auto-generated constructor stub
	}

	public Reader(String readerName, String readerEmail) {
		this.readerName = readerName;
		this.readerEmail = readerEmail;
	}

	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderEmail() {
		return readerEmail;
	}

	public void setReaderEmail(String readerEmail) {
		this.readerEmail = readerEmail;
	}

	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", readerName=" + readerName + ", readerEmail=" + readerEmail + "]";
	}

}
