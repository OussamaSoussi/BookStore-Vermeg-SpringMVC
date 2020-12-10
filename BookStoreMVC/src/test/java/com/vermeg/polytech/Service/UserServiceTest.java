package com.vermeg.polytech.Service;


import static org.junit.Assert.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.vermeg.polytech.DAO.IDAO;
import com.vermeg.polytech.model.User;

public class UserServiceTest {

	@Mock
	public IDAO<User> userDAO;

	@InjectMocks
	public UserService userService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void shouldReturnUserList() {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(1,"oussema","osoussi@vermeg.com","azert12",23703187));
		userList.add(new User(2,"soussi","osousssi@vermeg.com","azert123",22268193));
		when(userDAO.find()).thenReturn(userList);
		assertTrue("Test failed: Array size is wrong", this.userService.find().size() == userList.size());
		assertTrue("Test failed: First element is not equal to the first element the mocked list",
					this.userService.find().get(0).equals(userList.get(0))
				);
	}
	
	@Test
	public void shouldAddUserSuccessfully() {
		User user = new User(1,"oussema","osoussi@vermeg.com","azert12",23703187);
		userService.add(user);
        verify(userDAO, times(1)).add(user);
		}
	
	@Test
	public void shouldUpdateUserSuccessfully() {
		User user = new User(1,"oussema","osoussi@vermeg.com","azert12",23703187);
		userService.update(user);
        verify(userDAO, times(1)).update(user);
	}
	
	@Test
	public void shouldDeleteUserSuccessfully() {
		User user = new User(1,"oussema","osoussi@vermeg.com","azert12",23703187);
		userService.delete(user);
        verify(userDAO, times(1)).delete(user);
	}
		
}

