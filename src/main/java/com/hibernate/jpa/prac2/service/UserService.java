package com.hibernate.jpa.prac2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.jpa.prac2.entity.User;
import com.hibernate.jpa.prac2.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User insertUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Integer id) {
		 return userRepository.findById(id);
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
	
}
