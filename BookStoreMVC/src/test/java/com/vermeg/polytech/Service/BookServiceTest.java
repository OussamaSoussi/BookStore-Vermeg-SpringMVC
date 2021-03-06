package com.vermeg.polytech.Service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vermeg.polytech.DAO.IDAO;
import com.vermeg.polytech.model.Book;

public class BookServiceTest {
	
	//The @Mock annotation creates a mock implementation for the class it is annotated with.
	@Mock
	private IDAO<Book> mockedBookDAO;
	
	//@InjectMock creates an instance of the class and 
	//injects the mocks that are marked with the annotations @Mock into it.
	@InjectMocks
	private BookService bookService;
	
	@Before
	public void setup() {
		//if we don't call below, we will get NullPointerException
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFind() {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(1,"title1","author1",50d,null));
		books.add(new Book(2,"title2","author2",10d,null));
		books.add(new Book(3,"title3","author3",20d,null));
		when(this.mockedBookDAO.find()).thenReturn(books);
		assertTrue("Test failed: Size of list isn't equal to the size of the present test",
				this.bookService.find().size() == books.size());
	}

	@Test
	public void testFindById() {
		Book book = new Book(4,"title4","author4",100d,null);
		int id = book.getId();
		when(mockedBookDAO.findById(id)).thenReturn(book);
		assertEquals(4,book.getId());
		assertTrue("Test failed: Not matching Book ID",this.bookService.findById(id) == book);
	}

	@Test
	public void shouldAddBookSuccessfully() {
		Book book = new Book(4,"title4","author4",100d,null);
		bookService.add(book);
        verify(mockedBookDAO, times(1)).add(book);
		}
	
	@Test
	public void shouldUpdateBookSuccessfully() {
		Book book = new Book(4,"title4","author4",100d,null);
		bookService.update(book);
        verify(mockedBookDAO, times(1)).update(book);
		}
	

	@Test
	public void shouldDeleteBookSuccessfully() {
		Book book = new Book(4,"title4","author4",100d,null);
		bookService.delete(book);
        verify(mockedBookDAO, times(1)).delete(book);
		}
	}

