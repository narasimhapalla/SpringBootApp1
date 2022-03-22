package com.palla.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.palla.data.Post;
import com.palla.data.User;
import com.palla.exceptions.UserNotFoundException;
import com.palla.servcies.UserDaoService;
import com.palla.servcies.UserJPARepository;

@RestController
public class UserJPAH2Controller {
	
	@Autowired
	private UserJPARepository service;
	
	@RequestMapping(method=RequestMethod.GET, path="/jpa/users/{id}")
	public EntityModel<User> getUser(@PathVariable Integer id) {
		Optional<User> user = service.findById(id);
		if(!user.isPresent() ) {
			throw new UserNotFoundException(" id : "+id);
		}
		EntityModel<User> model = EntityModel.of(user.get());
		WebMvcLinkBuilder linktoUsers = linkTo(methodOn(this.getClass()).getUsers());
		model.add(linktoUsers.withRel("all-users"));
		return model;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/jpa/usersAll")
	public List<User> getUsers(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/jpa/users/save", consumes = {"text/plain", "application/json"})
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/jpa/users/{id}/posts")
	public List<Post> getPost(@PathVariable Integer id) {
		Optional<User> userO = service.findById(id);
		if(!userO.isPresent() ) {
			throw new UserNotFoundException(" id : "+id);
		}
		
		User user = userO.get();

		List<Post> posts = user.getPosts();
		return posts;
	}
}
