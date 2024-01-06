package com.numetry.evoting.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.numetry.evoting.dao.UserDao;
import com.numetry.evoting.dto.ResponseStructure;
import com.numetry.evoting.dto.User;
import com.numetry.evoting.exception.IdNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("User Registration Succefully");
		structure.setBody(dao.saveUser(user));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("User updation Succefully");
		structure.setBody(dao.updateUser(user));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> getUser(int id) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recBook = dao.getUser(id);
		if (recBook.isPresent()) {
			structure.setMessage("User Found");
			structure.setBody(recBook.get());
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}

		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setBody(dao.getAllUser());
		structure.setMessage("All User are display");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		Optional<User> recUser = dao.getUser(id);
		if (recUser.isPresent()) {
			dao.deleteUser(id);
			structure.setMessage("User Found");
			structure.setBody("User deleted");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}

		throw new IdNotFoundException();
	}

}
