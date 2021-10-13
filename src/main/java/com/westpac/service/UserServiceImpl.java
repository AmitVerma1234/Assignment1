package com.westpac.service;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.westpac.dao.UserDao;
import com.westpac.entity.User;

/*
 * Implementation code for handling User's Services.
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	// Constructor
	UserServiceImpl() {
	}

	/*
	 * To get All User details
	 */
	@Override
	@Fetch (FetchMode.SELECT) 
	public List<User> getUsers() {
		return userDao.findAll();
	}
}
