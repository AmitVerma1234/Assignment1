package com.westpac.service;

import java.util.List;

import com.westpac.entity.Post;

/*
 * Interface for Post's Requests.
 */

public interface PostService {

	/*
	 * To get All Blog Posts
	 */
	public List<Post> getPosts();

	/*
	 * To Add a user's post to existing posting list.
	 */
	public Post addPosts(Post post);

}