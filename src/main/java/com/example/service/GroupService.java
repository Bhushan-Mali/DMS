package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CommonResponseVO;
import com.example.model.Group;
import com.example.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	GroupRepository groupRepository;
	
	CommonResponseVO response = new CommonResponseVO();
	
	public CommonResponseVO addGroup(Group group) {
		groupRepository.save(group);
		CommonResponseVO response = new CommonResponseVO();
		response.setMessage("Group added successfully");
		return response;
	}

	public List<Group> getGroups() {
		List<Group> groups = groupRepository.findAll();
		return groups;
	}
	
	public Group getGroupById(Integer groupId) {
		Group group  = groupRepository.findByGroupId(groupId);
		return group;
	}
	
	public Group getGroupByName(String name) {
		Group group = groupRepository.findByGroupName(name);
		return group;
	}

	public CommonResponseVO updateGroup(Group group, Integer groupId) {
		Group group1 = groupRepository.findByGroupId(groupId);
		group1.setGroupName(group.getGroupName());
		group1.setOwner(group.getOwner());
		group1.setComments(group.getComments());
		group1.setGroupCode(group.getGroupCode());
		groupRepository.save(group1);
		response.setMessage("Group information updated successfully");
		return response;
	}

	public CommonResponseVO deleteGrooup(Integer groupId) {
		groupRepository.deleteById(groupId);
		response.setMessage("Group deleted successfully");
		return response;
	}



}
