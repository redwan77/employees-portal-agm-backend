package com.jobcommit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobcommit.model.Notification;

public interface  NotificationRepository extends JpaRepository<Notification, Long> {
	
	public List<Notification> findByUserId(Long id);

}
