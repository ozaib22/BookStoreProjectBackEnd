package com.example.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.book.domain.Book;

@Repository

public interface BookRepo extends JpaRepository<Book, Integer> {

	// This will auto gen the crud functions
}
