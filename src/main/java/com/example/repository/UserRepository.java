package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public List<User> findAll();
	public User save(User user);
	public User findByUserid(Long userid);
	public void deleteById(Long userid);
	public List<User> getUserByUsername(String username);
	public User findByEmail(String email);
}
