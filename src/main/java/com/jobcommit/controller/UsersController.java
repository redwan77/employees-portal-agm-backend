package com.jobcommit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobcommit.dto.UserDTO;
import com.jobcommit.model.Role;
import com.jobcommit.model.User;
import com.jobcommit.repository.UserRepository;

@RestController
@RequestMapping("users")
@CrossOrigin("**")
public class UsersController {

	@Autowired
	public UserRepository usersController;
	
	@PostMapping("addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody UserDTO body) {
		User user = new User();
		user.setAdress(body.getAdress());
		user.setRole(Role.EMPLOYEE);
		user.setName(body.getName());
		user.setEmail(body.getEmail());
		user.setLastName(body.getLastName());
		user.setRemote(body.getIsRemote());
		user.setPhoneNumber(body.getPhoneNumber());
		this.usersController.save(user);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
