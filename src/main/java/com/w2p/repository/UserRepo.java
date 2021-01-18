package com.w2p.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.w2p.model.entity.User;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {


	User findByUsername(String username);
	User findByUsernameIgnoreCase(String username);
	
}