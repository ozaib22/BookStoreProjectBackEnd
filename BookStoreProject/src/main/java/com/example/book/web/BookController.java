package com.example.book.web;

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
import org.springframework.web.bind.annotation.RestController;
import com.example.book.domain.Book;
import com.example.book.service.BookService;


@CrossOrigin
@RestController
public class BookController {

private BookService service;

@Autowired //tells spring to fetch the book service from the context - depend injec
public BookController(BookService service) {
	super();
	this.service=service;
}

	
	@PostMapping("/create")// This will pull the details from the body of the request
	public ResponseEntity<Book> createbook(@RequestBody Book ref) {
	
		Book created = this.service.createbook(ref);
		ResponseEntity<Book> response = new ResponseEntity<Book>(created, HttpStatus.CREATED); // 201 code is created code for HTTP
		return response;
	}
	
	@GetMapping("/getAll")
	
	public ResponseEntity<List<Book>> getAllpages(){
			return ResponseEntity.ok(this.service.getAllpages()); //200 - ok
}
	
	@GetMapping("/get/{Book_id}") // 200 ok
	public Book getbook(@PathVariable Integer Book_id) {
		return this.service.getbook(Book_id);
	}
		
	@PutMapping("/replace") 
	public ResponseEntity<Book> replacebook (@RequestBody Book newbook) {
		
		System.out.println("======>");
		Book body = this.service.replacebook(newbook.getBook_id() , newbook);
		ResponseEntity<Book> response = new ResponseEntity<Book>(body, HttpStatus.ACCEPTED);
		return response;
	}
		
	@DeleteMapping("/remove/{Book_id}") // 204 no content
	public ResponseEntity<?> removebook(@PathVariable Integer Book_id) {
		this.service.removebook(Book_id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
		
	}


}
