package com.westpac.service;

import java.util.List;

import com.westpac.entity.User;

/*
 * Interface for User's Requests.
 */

public interface UserService {

	public List<User> getUsers();

}