package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CommonResponseVO;
import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	public CommonResponseVO saveUser(User user) {
        userRepository.save(user);
        CommonResponseVO response = new CommonResponseVO();
        response.setMessage("User added successfully");
        return response;
    }
	
	public List<User> getUser() {		
		return userRepository.findAll();
	}

	public User getUserById(Long userid) {
		return userRepository.findByUserid(userid);		
	}

	public CommonResponseVO updateUser(Long userid, User user) {
		User user1 = userRepository.findByUserid(userid);
		CommonResponseVO response = new CommonResponseVO();
		
		user1.setUsername(user.getUsername());
		user1.setRealname(user.getRealname());
		user1.setEmail(user.getEmail());
		user1.setDesignation(user.getDesignation());
		user1.setDepartment(user.getDepartment());
		user1.setDateOfBirth(user.getDateOfBirth());
		user1.setCreationDate(user.getCreationDate());
		user1.setContact(user.getContact());
		user1.setAge(user.getAge());
		userRepository.save(user1);
		response.setMessage("User details updated successfully");
		return response;
	}

	public CommonResponseVO deleteUserById(Long userid) {
		CommonResponseVO response = new CommonResponseVO();
		userRepository.deleteById(userid);
		response.setMessage("User deleted successfully");
		return response;
	}

	public List<User> getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);		
	}

	public User getUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		if(user != null ) {
			return user;
		}
		return null;
	}
	
	
}
