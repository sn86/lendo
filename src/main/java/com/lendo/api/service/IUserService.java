package com.lendo.api.service;

import com.lendo.api.model.Comment;
import com.lendo.api.model.Post;
import com.lendo.api.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    List<Post> getAllUserPost();

    List<Comment> getAllUserComments();
}
