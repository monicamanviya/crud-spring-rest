package com.library.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.library.entity.BookDetails;
import com.library.exception.ResourceNotFoundException;
@Repository
public class BookDetailsDAOImpl implements BookDetailsDAO{

	

	@Autowired
	private EntityManager entitymanager;
	
	@Override
	@Transactional
	public List<BookDetails> listAllBooks() {
		Session session = entitymanager.unwrap(Session.class);
		Query<BookDetails> theQuery = session.createQuery("from BookDetails b where b.status=1", BookDetails.class);
		List<BookDetails> books = theQuery.getResultList();
		return books;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session session = entitymanager.unwrap(Session.class);
		session.get(BookDetails.class, id).setStatus(2);
	}

	@Override
	@Transactional
	public int addNewBook(BookDetails bookDetails) {
		Session session = entitymanager.unwrap(Session.class);
		return (Integer) session.save(bookDetails);
	}

	@Override
	@Transactional
	public void updateBookDetails(BookDetails bookDetails) {
		
        Session session = entitymanager.unwrap(Session.class);
		TypedQuery<BookDetails> theQuery = session.createQuery("from BookDetails b where b.id=:id", BookDetails.class);
		theQuery.setParameter("id", bookDetails.id);
		BookDetails books=theQuery.getSingleResult();
		books.setId(bookDetails.getId());
		books.setAuthor(bookDetails.getAuthor());
		books.setTitle(bookDetails.getTitle());
		books.setNumberOfbooks(bookDetails.getNumberOfbooks());
		books.setStatus(bookDetails.getStatus());
		session.saveOrUpdate(books);
		
	}

	@Override
	@Transactional
	public BookDetails findById(int id) {
		Session session = entitymanager.unwrap(Session.class);
		BookDetails details = session.get(BookDetails.class, id);
		if(details==null) {
			throw new ResourceNotFoundException("Books not found with id " +id);
		}
		return details;
	}

}
