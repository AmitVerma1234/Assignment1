package com.westpac.service;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.westpac.dao.PostDao;
import com.westpac.entity.Post;

/*
 * Implementation code for handling Post Services.
 */

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	// Constructor
	PostServiceImpl() {
	}

	/*
	 * To return All Posts
	 */
	@Override
	@Fetch(FetchMode.SELECT)
	public List<Post> getPosts() {
		return postDao.findAll();
	}

	/*
	 * To Add a post into Database and store it.
	 */
	@Override
	public Post addPosts(Post post) {
		postDao.save(post);
		return post;
	}

}
