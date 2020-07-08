package com.jobcommit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobcommit.model.DailyRecord;
import com.jobcommit.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	public Long hasCreatedDaily(Long userId) {
		Long daily = this.userRepository.findDailyByDateAndUser(userId);
		return daily ;
	}
	

}
