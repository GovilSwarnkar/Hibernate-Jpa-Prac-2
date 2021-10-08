package com.hibernate.jpa.prac2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hibernate.jpa.prac2.entity.User;
import com.hibernate.jpa.prac2.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//add user from cmd using curl
	//curl localhost:8080/users/add -d name=Shiva -d email=shiva@gamil.com
	//@RequestParam annotation used for accessing the query parameter values from the request
	@PostMapping(path = "/add")
	public @ResponseBody User addUser(@RequestParam String name, @RequestParam String email) {
		return userService.insertUser(new User(name, email));
	}
	
	@GetMapping(path = "/user/{id}") // @ResponseBody means the returned value is the response, not a view name
	public @ResponseBody Object getUserById(@PathVariable Integer id) {
		Optional<User> userOptional = userService.getUserById(id);
		return userOptional.isPresent() ? userOptional.get() : "User not found";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody List<User> getUsers(){
		return userService.getUsers();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String deleteUserById(@PathVariable Integer id) {
		userService.deleteUserById(id);
		return "User deleted Successfully";
	}
	
}