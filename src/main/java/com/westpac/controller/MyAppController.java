package com.westpac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.westpac.entity.Post;
import com.westpac.entity.User;
import com.westpac.service.PostService;
import com.westpac.service.UserService;

/*
 * The main Controller of the Spring Application.
 * The web requests are handled here.
 */

@RestController
public class MyAppController {

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;

	/*
	 * To Test initial application setup
	 */
	@GetMapping("/home")
	public String testHome() {
		return "Check for REST Controllers's home method.";
	}

	/*
	 * To handle All user fetch request.
	 */
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> response = null;
		response = this.userService.getUsers();

		if (null == response || response.size() == 0) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}

		return ResponseEntity.ok(response);
	}

	/*
	 * To handle all posts fetch request.
	 */
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getPosts() {
		List<Post> response = null;
		response = this.postService.getPosts();

		if (null == response || response.size() == 0) {
			return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
		}

		return ResponseEntity.ok(response);
	}

	/*
	 * To add a post.
	 */
	@PostMapping(path = "/posts", consumes = "application/json")
	public Post addPosts(@RequestBody Post post) {
		return this.postService.addPosts(post);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}
}
