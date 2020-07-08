package com.jobcommit.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobcommit.model.DailyRecord;

public interface DailyRecordService extends JpaRepository<DailyRecord, Long>{

	
}
