package com.jobcommit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobcommit.model.Role;
import com.jobcommit.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByRole(Role role);

	public List<User> findByNameContaining(String likeKey);

	public User findByLoginAndPassword(String email, String password) ;
}
