package com.westpac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.westpac.entity.Post;

public interface PostDao extends JpaRepository<Post, Long> {

}
