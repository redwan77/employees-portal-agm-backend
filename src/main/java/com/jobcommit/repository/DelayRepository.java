package com.jobcommit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobcommit.model.DailyRecord;
import com.jobcommit.model.Delay;

public interface DelayRepository extends JpaRepository<Delay, Long> {
	
	public List<Delay> findByUserId(Long id);

}
