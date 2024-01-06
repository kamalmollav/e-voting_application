package com.numetry.evoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.evoting.dto.ResponseStructure;
import com.numetry.evoting.dto.User;
import com.numetry.evoting.services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices services;

	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> getUser(@PathVariable int id) {
		return services.getUser(id);
	}

	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
		return services.getAllUser();
	}

	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveBook(@RequestBody User user) {
		return services.saveUser(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> updateBook(@PathVariable int id, @RequestBody User user) {
		return services.updateUser(user);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteBook(@PathVariable int id) {
		return services.deleteUser(id);
	}

}
