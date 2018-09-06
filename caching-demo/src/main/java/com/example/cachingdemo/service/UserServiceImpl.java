package com.example.cachingdemo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.cachingdemo.model.Users;

@Service
@Transactional
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;
	
	@Cacheable(value="usernameCache",key="#userId")
	public Users getUserByUserId(String userId) {
		System.out.println("Getting Data from DB");
		return userRepository.getUsersByUserLogin(userId);
	}
}
