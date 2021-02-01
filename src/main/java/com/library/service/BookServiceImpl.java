package com.library.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.entity.BookDetails;
import com.library.repository.BookDetailsDAO;

@Service
public class BookServiceImpl implements BookService {

	
@Autowired
public BookDetailsDAO booksdao;



	public BookServiceImpl(BookDetailsDAO booksdao) {
	super();
	this.booksdao = booksdao;
}

	@Override
	public List<BookDetails> listAllBooks() {
		List<BookDetails> books = booksdao.listAllBooks();
		return books;
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		booksdao.deleteById(id);
	}

	@Override
	public int addNewBook(BookDetails bookDetails) {
		return booksdao.addNewBook(bookDetails);
	}

	@Override
	public void updateBookDetails(BookDetails bookDetails) {
		booksdao.updateBookDetails(bookDetails);
		
	}

	@Override
	public BookDetails findById(int id) {
	return booksdao.findById(id);
	}

}
