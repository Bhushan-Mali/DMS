package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>{

	Group findByGroupId(Integer groupId);

	Group findByGroupName(String name);

}
