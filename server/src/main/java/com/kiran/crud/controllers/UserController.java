package com.kiran.crud.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.crud.entity.User;
import com.kiran.crud.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
	public UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/health")
    public String healthcheck() throws InterruptedException,ExecutionException  {
        return "Server working well 🔃✅ 🔥💫";
    }
	
	@GetMapping("/all")
    public List<User> getAllUsers() throws InterruptedException,ExecutionException  {
        return userService.getAll();
    }
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable String userId) throws InterruptedException,ExecutionException {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/create")
	public String createUser(@RequestBody User userData) throws InterruptedException,ExecutionException {
		return userService.createUser(userData);
	}
	
	@PatchMapping("/update/{id}")
	public String updateUser(@PathVariable String id, @RequestBody User updatedUser) throws InterruptedException,ExecutionException {
		return userService.updateUser(id,updatedUser);
	}
	
	@DeleteMapping("/remove/{id}")
	public String deleteUser(@PathVariable String id) throws InterruptedException,ExecutionException {
		return userService.deleteUserById(id);
	}
}
