package com.lendo.api.controller;

import com.lendo.api.model.Comment;
import com.lendo.api.model.Post;
import com.lendo.api.model.User;
import com.lendo.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("users")
public class UserController {

	private final IUserService userService;

	@Autowired
	UserController(IUserService userService){
	this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	@GetMapping("comments")
	public ResponseEntity<List<Comment>> getAllUserComments(
			@RequestParam(name = "postIds",required = false) List<Integer> postIds) {
		List<Comment> comments = userService.getAllUserComments();

		if(postIds!=null && !postIds.isEmpty()) {
			List<Comment> filteredComment = new ArrayList<>();
			postIds.stream().forEach(id -> {
				filteredComment.addAll(comments.stream().filter(comment -> comment.getPostId() == id.intValue()).collect(Collectors.toList()));
			});
			return new ResponseEntity<>(filteredComment, HttpStatus.OK);
		}

		return new ResponseEntity<>(comments, HttpStatus.OK);
	}

	@GetMapping("posts")
	public ResponseEntity<List<Post>> getAllPosts() {
		List<Post> post = userService.getAllUserPost();
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
}
