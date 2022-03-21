package com.palla.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.palla.data.User;
import com.palla.exceptions.UserNotFoundException;
import com.palla.servcies.UserDaoService;

@RestController
public class UserController {
	@Autowired
	private UserDaoService service;
	
	@RequestMapping(method=RequestMethod.GET, path="/users/{id}")
	public User getUser(@PathVariable Integer id) {
		User user = service.getUser(id);
		if(user == null ) {
			throw new UserNotFoundException(" id : "+id);
		}
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/usersAll")
	public List<User> getUsers(){
		return service.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/users/save", consumes = {"text/plain", "application/json"})
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = service.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
