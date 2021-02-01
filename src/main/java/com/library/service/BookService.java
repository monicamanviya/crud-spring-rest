package com.library.service;

import java.util.List;

import com.library.entity.BookDetails;

public interface BookService {
	public List<BookDetails> listAllBooks();
	public BookDetails findById(int id);
	public void deleteById(int id);
	public int addNewBook(BookDetails bookDetails);
	public void updateBookDetails(BookDetails bookDetails);
}
