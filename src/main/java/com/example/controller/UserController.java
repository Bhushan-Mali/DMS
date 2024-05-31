package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CommonResponseVO;
import com.example.model.User;
import com.example.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;

	
	@PostMapping("saveUser")
    public ResponseEntity<CommonResponseVO> saveUser(@RequestBody User user) {
		CommonResponseVO response = userService.saveUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }	
	
	@GetMapping("users")
	public ResponseEntity<List<User>> getUser() {	
		List<User> userList = userService.getUser();		
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	@GetMapping("/users/{userid}")
	public ResponseEntity<User> getUserById(@PathVariable("userid") Long userid) {
		User user = userService.getUserById(userid);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("user/{username}")
	public ResponseEntity<List<User>> getUserByUsername(@PathVariable("username") String username) {
		List<User> userList = userService.getUserByUsername(username);
		if (userList != null && !userList.isEmpty()) {
			return new ResponseEntity<List<User>>(userList, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);				
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<?> getUserByEmail(@RequestParam String email) {
		User user = userService.getUserByEmail(email);
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.FOUND);
		}
		return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/users/{userid}")
	public ResponseEntity<CommonResponseVO> updateUser(@PathVariable("userid") Long userid, @RequestBody User user) {
		CommonResponseVO response = userService.updateUser(userid,user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("users/{userid}")
	public ResponseEntity<CommonResponseVO> deleteUserById(@PathVariable("userid") Long userid) {
		CommonResponseVO response = userService.deleteUserById(userid);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
