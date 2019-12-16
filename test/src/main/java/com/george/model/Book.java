package com.george.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uniqueId;
	private String title;
	private String isbn;
	private String author;
	private String edition;
	private String category;
	
	public Book() {
		super();
	}

	public Book(long uniqueId, String title, String isbn, String author, String edition, String category) {
		super();
		this.uniqueId = uniqueId;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.edition = edition;
		this.category = category;
	}

	public long getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(long uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [uniqueId=" + uniqueId + ", title=" + title + ", isbn=" + isbn + ", author=" + author
				+ ", edition=" + edition + ", category=" + category + "]";
	}
}
