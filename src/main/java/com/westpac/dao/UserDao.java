package com.westpac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.westpac.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
