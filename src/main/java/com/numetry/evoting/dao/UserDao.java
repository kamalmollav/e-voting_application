package com.numetry.evoting.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.numetry.evoting.dto.User;
import com.numetry.evoting.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User updateUser(User user) {
		return repository.save(user);
	}

	public Optional<User> getUser(int id) {
		return repository.findById(id);
	}

	public List<User> getAllUser() {
		return repository.findAll();
	}

	public void deleteUser(int id) {
		repository.deleteById(id);

	}

}
