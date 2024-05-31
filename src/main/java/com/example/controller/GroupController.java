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
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CommonResponseVO;
import com.example.model.Group;
import com.example.service.GroupService;

@RestController
public class GroupController {

	@Autowired
	GroupService groupService;
	
	@PostMapping("/addGroup")
	public ResponseEntity<?> addGroup(@RequestBody Group group){
	   CommonResponseVO response = groupService.addGroup(group);
	   return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/groups")
	public ResponseEntity<List<Group>> getGroups() {
		List<Group> groups = groupService.getGroups();
		return new ResponseEntity<>(groups, HttpStatus.FOUND);
	}
	
	@GetMapping("/groups/{groupId}")
	public ResponseEntity<?> getGroupById(@PathVariable("groupId") Integer groupId) {
		Group group = groupService.getGroupById(groupId);
		if(group != null) {
			return new ResponseEntity<>(group, HttpStatus.FOUND);
		}
		return new ResponseEntity<String>("Group isn't present with given id", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/group/{groupName}")
	public ResponseEntity<?> getGroupByName(@PathVariable("groupName") String name) {
		Group group = groupService.getGroupByName(name);
		if(group != null) {
			return new ResponseEntity<>(group, HttpStatus.FOUND);
		}
		return new ResponseEntity<String>("Group isn't present with given name", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/groups/update/{groupId}")
	public ResponseEntity<CommonResponseVO> updateGroup(@RequestBody Group group, @PathVariable("groupId") Integer groupId) {
		CommonResponseVO response = groupService.updateGroup(group, groupId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}	
	
	@DeleteMapping("/groups/delete/{groupId}")
	public ResponseEntity<CommonResponseVO> deleteGrooup(@PathVariable("groupId") Integer groupId) {
		CommonResponseVO response = groupService.deleteGrooup(groupId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
