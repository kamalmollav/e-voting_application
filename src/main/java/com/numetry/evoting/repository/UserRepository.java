package com.numetry.evoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.numetry.evoting.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
