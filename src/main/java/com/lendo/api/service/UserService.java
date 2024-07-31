package com.lendo.api.service;

import com.lendo.api.model.Comment;
import com.lendo.api.model.Post;
import com.lendo.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


public class UserService implements IUserService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<User> getAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(
                        "https://gorest.co.in/public/v2/users",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<User>>() {}
                );

        List<User> users= responseEntity.getBody();

        return users;
    }



    @Override
    public List<Post> getAllUserPost() {
        System.out.println("GetAll Users");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        ResponseEntity<List<Post>> responseEntity =
                restTemplate.exchange(
                        "https://gorest.co.in/public/v2/posts",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Post>>() {}
                );

        List<Post> post= responseEntity.getBody();

        return post;
    }



    @Override
    public List<Comment> getAllUserComments() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        ResponseEntity<List<Comment>> responseEntity =
                restTemplate.exchange(
                        "https://gorest.co.in/public/v2/comments",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Comment>>() {}
                );

        List<Comment> comments= responseEntity.getBody();

        return comments;
    }
}
