package com.example.book.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.book.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts={"classpath:book-schema.sql", "classpath:book-data.sql"}, executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")


public class BookControllerIntergrationTest {
	
	
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	
	
	@Test
	void testCreated() throws Exception {
		Book testBook = new Book(null,"Art of War", 30,1990);
		String testBookAsJSON=this.mapper.writeValueAsString(testBook);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testBookAsJSON);
		
		Book testCreatedBook = new Book(3,"Art of War", 30,1990);
		String testCreatedBookAsJSON = this.mapper.writeValueAsString(testCreatedBook);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedBookAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void getAllTest() throws Exception {
		RequestBuilder req =get("/getAll");
		List<Book> testPages = List.of(new Book(1,"Mice",30,1990),new Book(2,"Harry Potter", 40, 1995));
				String json = this.mapper.writeValueAsString(testPages);
				ResultMatcher checkStaus= status().isOk();
				ResultMatcher checkBody = content().json(json);
				
				this.mvc.perform(req).andExpect(checkStaus).andExpect(checkBody);
				
		
	}
	
	@Test
	void getTest() throws Exception {
		RequestBuilder req = get("/get/1");
		String bookAsJson = this.mapper.writeValueAsString(new Book(1, "Mice",30,1990));
		ResultMatcher checkStaus= status().isOk();
		ResultMatcher checkBody = content().json(bookAsJson);
		
		this.mvc.perform(req).andExpect(checkStaus).andExpect(checkBody);
		
	}
	
		
	
	@Test
	void testReplace() throws Exception {
		Book testBook = new Book(null, "Random", 50,2000);
		String testBookAsJson = this.mapper.writeValueAsString(testBook);
		RequestBuilder req = put("/replace").contentType(MediaType.APPLICATION_JSON).content(testBookAsJson);
		
		Book testCreatedBook = new Book(1,"Random",50,2000);
		String testCreatedBookAsJSON = this.mapper.writeValueAsString(testCreatedBook);
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testCreatedBookAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
				
	}
	
	@Test
	void TestRemove() throws Exception {
		this.mvc.perform(delete("/remove")).andExpect(status().isNoContent());
	}
}
