package com.example.book.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.book.domain.Book;
import com.example.book.repo.BookRepo;

@Service
public class BookService {

	private BookRepo repo;
	
	@Autowired
	public BookService(BookRepo repo) {
		super();
		this.repo=repo;
		
	}
	
	
	//CREATE
	public Book createbook(Book A) {
		Book created = this.repo.save(A); // insert into Person;
		return created;
	}
	
	//READ
	public List<Book> getAllpages() {
		return this.repo.findAll();
		
	}

	public Book getbook(Integer book_id) {
		Optional<Book> found = this.repo.findById(book_id);
		return found.get();
		
	}
	
	
	//UPDATE
	public Book replacebook(Integer Book_id, Book newbook) {
		Book existing = this.repo.findById(Book_id).get();
		existing.setName(newbook.getName());
		existing.setPrice(newbook.getPrice());
		existing.setPublish_date(newbook.getPublish_date());
		Book updated = this.repo.save(existing);
		return updated;
		
	}
	
	
	//DELETE
	public void removebook (@PathVariable Integer Book_id) {
		this.repo.deleteById(Book_id);
		
		
	}
	
}
