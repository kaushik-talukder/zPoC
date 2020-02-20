package com.example.poc.restws;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.poc.restws.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.findAllUsers();
	}

	@GetMapping("/users/{id}")
	public User getOneUser(@PathVariable Integer id) {
		User user = service.findOne(id);
		if (user == null)
			throw new UserNotFoundException("User not found");
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User newUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		User user = service.deleteById(id);
		if (user == null)
			throw new UserNotFoundException("User not found");
	}
}
