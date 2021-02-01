package com.library.repository;

import java.util.List;


import com.library.entity.BookDetails;

public interface BookDetailsDAO {

	public List<BookDetails> listAllBooks();
	public BookDetails findById(int id);
	public void deleteById(int id);
	public int addNewBook(BookDetails bookDetails);
	public void updateBookDetails(BookDetails bookDetails);
}
