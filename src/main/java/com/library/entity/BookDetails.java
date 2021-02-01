package com.library.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_book_details")
public class BookDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int id;
	@Column(name = "TITLE")
	public String title;
	@Column(name = "AUTHOR")
	public String author;
	@Column(name = "NUMBER_OF_BOOKS")
	public int numberOfbooks;
	@Column(name = "STATUS")
	public int status;
	public BookDetails() {
		
	}
	public BookDetails(int id, String title, String author, int numberOfbooks, int status) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.numberOfbooks = numberOfbooks;
		this.status = status;
	}
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNumberOfbooks() {
		return numberOfbooks;
	}
	public void setNumberOfbooks(int numberOfbooks) {
		this.numberOfbooks = numberOfbooks;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BookDetails [id=" + id + ", title=" + title + ", author=" + author + ", numberOfbooks=" + numberOfbooks
				+ ", status=" + status + "]";
	}

}
