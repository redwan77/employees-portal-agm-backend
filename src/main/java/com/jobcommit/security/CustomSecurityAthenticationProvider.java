package com.jobcommit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobcommit.model.User;
import com.jobcommit.repository.UserRepository;

@Service
public class CustomSecurityAthenticationProvider {

	
	public  UserRepository userRepository;

	public static UserRepository repo ;
	
	public static CustomSecurityUserDetails userDetails;
	
	@Autowired
	public CustomSecurityAthenticationProvider(UserRepository r) {
		this.userRepository = r ;
		CustomSecurityAthenticationProvider.repo = r;
	}

	public static boolean authenticate(CustomBasicAutheticationUserCredentials credentials) {
		User user = CustomSecurityAthenticationProvider.repo.findByEmailAndPassword(credentials.getLogin(), credentials.getPassword());
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
