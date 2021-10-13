package com.westpac;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.westpac.controller.MyAppController;
import com.westpac.dao.UserDao;
import com.westpac.entity.Address;
import com.westpac.entity.Company;
import com.westpac.entity.Geo;
import com.westpac.entity.User;
import com.westpac.service.PostServiceImpl;
import com.westpac.service.UserServiceImpl;

@WebMvcTest(MyAppController.class)
public class MyAppControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	public UserDao userDao;

	// Geo Object.
	@MockBean
	public Geo testGeo;

	// Address Object.
	@MockBean
	public Address testAddress;

	// Company Object.
	@MockBean
	public Company testCompany;

	// User Object.
	@MockBean
	public User testUser;

	// UserServiceImpl Object.
	@MockBean
	public UserServiceImpl testUserServiceImpl;

	// User PostServiceImpl.
	@MockBean
	public PostServiceImpl testPostServiceImpl;

	@BeforeEach
	public void setupMock() {
		testGeo = mock(Geo.class);
		testAddress = mock(Address.class);
		testCompany = mock(Company.class);
		testUser = mock(User.class);
		testUserServiceImpl = mock(UserServiceImpl.class);
		testPostServiceImpl = mock(PostServiceImpl.class);

		testGeo.setId(1L);
		testGeo.setLat("1.1");
		testGeo.setLng("2.2");

		testAddress.setId(1L);
		testAddress.setStreet("Test Street");
		testAddress.setSuite("Test Suite");
		testAddress.setCity("Test City");
		testAddress.setZipcode("Zip 001");
		testAddress.setGeo(testGeo);

		testCompany.setId(1L);
		testCompany.setName("Test Company");
		testCompany.setCatchPhrase("Test Catch Phrase");
		testCompany.setBs("Test BS");

		testUser.setId(1L);
		testUser.setName("Test User");
		testUser.setUserName("test_user_001");
		testUser.setEmail("test.user@test.com");
		testUser.setAddress(testAddress);
		testUser.setPhone("1111");
		testUser.setWebsite("test.com");
		testUser.setCompany(testCompany);
	}

	@Test
	public void testGetUsers() throws Exception {

		List<User> users = new ArrayList<User>();
		users.add(testUser);

		userDao.saveAll(users);
		userDao.flush();

		Mockito.when(testUserServiceImpl.getUsers()).thenReturn(users);

		mockMvc.perform(MockMvcRequestBuilders.get("/users").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("[0]", Matchers.hasSize(1)))
				.andExpect(jsonPath("[0].name", is("Test User")));
	}
}
