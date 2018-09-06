package com.example.cachingdemo.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cachingdemo.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

	public Users getUsersByUserLogin(String userLogin);
	
}
