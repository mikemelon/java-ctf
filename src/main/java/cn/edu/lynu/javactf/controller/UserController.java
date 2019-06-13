package cn.edu.lynu.javactf.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.lynu.javactf.exception.UserNotFoundException;
import cn.edu.lynu.javactf.model.User;
import cn.edu.lynu.javactf.service.UserService;

@RestController
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/users")
	public List<User> findAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping(value = "/user/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/user")
	public void addUser(@RequestBody @Valid User user) {
		logger.info("add user:{}" , user);
		userService.save(user);
	}
	
	@PutMapping("/user")
	public void updateUser(@RequestBody @Valid User user) {
		logger.info("update user:{}" , user);
		userService.update(user);
	}
	
	@DeleteMapping(value = "/user/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if (userService.getUserById(id) == null) {
			throw new UserNotFoundException();
		}
		logger.info("delete user:id={}",id);
		userService.deleteUserById(id);
	}
}
