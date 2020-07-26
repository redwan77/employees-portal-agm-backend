package com.jobcommit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobcommit.model.Notification;
import com.jobcommit.repository.NotificationRepository;
import com.jobcommit.security.CustomSecurityAthenticationProvider;

@RestController
@RequestMapping("notification")
public class NotificationController {

	@Autowired
	public NotificationRepository notificationRepository;

	@GetMapping("/unseen-notifications")
	public List<Notification> getUserNotification(@PathVariable("id") Long id) {
		Long currentUser = CustomSecurityAthenticationProvider.userDetails.getId();
		return notificationRepository.findByUserId(currentUser);
	}

}
