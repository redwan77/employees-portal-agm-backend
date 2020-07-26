package com.jobcommit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Notification> getUserNotification() {
		
		Long currentUser = CustomSecurityAthenticationProvider.userDetails.getId();
		List<Notification>  result = notificationRepository.findByUserIdAndSeen(currentUser, false);
		return result ;
	}
	
	@PostMapping("markAsSeen")
	public boolean markNotificationsAsReaded(@RequestBody List<Long> id) {

		System.out.println("haha");
		id.forEach(nid -> {
			Notification not = notificationRepository.findById(nid).get() ;
			not.setSeen(true);
			notificationRepository.save(not) ;
		});
		return true;
	}

}
