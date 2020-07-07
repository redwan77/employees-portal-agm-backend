package com.jobcommit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobcommit.client_response.UserLoginSuccess;
import com.jobcommit.model.User;
import com.jobcommit.repository.UserRepository;
import com.jobcommit.security.forms.Login;

@RestController
@CrossOrigin("*")
@RequestMapping("login")
public class AuthenticationController {

	@Autowired
	public UserRepository userRepository;

	@PostMapping
	public ResponseEntity<?> login(@RequestBody Login login) {
		
		User user = userRepository.findByLoginAndPassword(login.getLogin(), login.getPassword());
		
		if (user != null) {
			
			UserLoginSuccess info = new UserLoginSuccess();
			
			info.setUsername(user.getName());
			
			info.setLastname(user.getLastName());
			
			info.setRole(user.getRole().name());
			
			return new ResponseEntity<>(info, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

}
