package com.numetry.evoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.evoting.dto.ResponseStructure;
import com.numetry.evoting.dto.User;
import com.numetry.evoting.services.UserServices;

@RestController
public class VoteController {

	@Autowired
	private UserServices services;

	@GetMapping("/vote/users")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
		User user = new User();
		if (user.getAge() > 18) {
			ResponseEntity<ResponseStructure<List<User>>> allUser = services.getAllUser();

		}
		return services.getAllUser();

	}

	@RequestMapping("vote/users/{name}")
	public String giveVote(@PathVariable String name) {
		User user = new User();
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (user.getAge() < 18) {
			return "you have succefully voting";
		} else {
			return "you are not able to vote";
		}

	}

}
