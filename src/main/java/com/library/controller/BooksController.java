package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.library.entity.BookDetails;
import com.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BooksController {

	
	@Autowired
	private BookService booksService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<BookDetails>> listofAllBooks() {
		return new ResponseEntity<List<BookDetails>>(booksService.listAllBooks(),HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getBookbyId(@PathVariable int id) {
		BookDetails bookDetails=booksService.findById(id);
		return new ResponseEntity<>(bookDetails,HttpStatus.OK);	
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable int id) {
		booksService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@PostMapping("/add")
	public ResponseEntity<BookDetails> addNewbook(@RequestBody BookDetails bookDetails) {
		booksService.addNewBook(bookDetails);
	return new  ResponseEntity<BookDetails>(bookDetails,HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<BookDetails> updateProduct(@RequestBody BookDetails bookDetails) {
		booksService.updateBookDetails(bookDetails);
	return new  ResponseEntity<BookDetails>(bookDetails,HttpStatus.OK);

	}
	
}
