package com.vermeg.polytech.controllers;

import org.junit.Test;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.vermeg.polytech.Service.BookService;
import com.vermeg.polytech.model.Book;

import static org.hamcrest.Matchers.*;

//@WebAppConfiguration
public class BookControllerTest {
	
//		@Autowired
//		private WebApplicationContext webApplicationContext;
		
		@Autowired
		private MockMvc mockMvc;

		@Mock
		private BookService MockedBookService;

		@InjectMocks
		private BookController bookController;

		@Before
		public void setup() throws Exception {
			//Informations for me:
//			//The class MockMvcBuilders has 2 methodes to instantiate the MockMVC.
//			//1) A method allowing to build an instance of MockMvc linked to a web context passed as a parameter.
//			
//			//mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//			
//			//The DispatcherServlet will use this context to define the set of REST controllers for the application.
//			//2) A method for building an instance of MockMvc in Standalone mode 
//			//and registering one or more application controllers in the web context by programming.
			
			MockitoAnnotations.initMocks(this);
			mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
		}

		@Test
		public void testGetAllBooks() throws Exception {
			List <Book> books = new ArrayList<Book>();
			books.add(new Book(1,"title1","author1",50d,null));
			books.add(new Book(2,"title2","author2",10d,null));
			books.add(new Book(3,"title3","author3",20d,null));
			
			when(MockedBookService.find()).thenReturn(books);

			this.mockMvc.perform(get("/book/all"))
//			.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
			.andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(3)))
			.andExpect(status().is2xxSuccessful());
			
		}

		@Test
		public void testGetBook() throws Exception {
			Book book = new Book(4,"title4","author4",100d,null);
			when(MockedBookService.findById(1)).thenReturn(book);
//			verify(MockedBookservice).getBookByISBN(1);
			this.mockMvc.perform(get("/book/get/{id}", 1))
			.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(4))
			.andExpect(status().is2xxSuccessful());
		}


}
