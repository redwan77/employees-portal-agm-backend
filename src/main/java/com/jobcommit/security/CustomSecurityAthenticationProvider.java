package com.jobcommit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobcommit.model.User;
import com.jobcommit.repository.UserRepository;

@Service
public class CustomSecurityAthenticationProvider {

	@Autowired
	private UserRepository userRepository;

	public static CustomSecurityUserDetails userDetails;

	public boolean authenticate(CustomBasicAutheticationUserCredentials credentials) {
		User user = this.userRepository.findByEmailAndPassword(credentials.getName(), credentials.getPassword());
		if (user != null) {
			CustomSecurityUserDetails dts = new CustomSecurityUserDetails();
			dts.setId(user.getId());
			dts.setName(user.getName());
			dts.setPassword(user.getPassword());
			dts.setRole(user.getRole());
			CustomSecurityAthenticationProvider.userDetails = dts;
			return true;
		}
		return false;
	}

}
