package com.jobcommit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobcommit.model.DailyRecord;

public interface DailyRecordRepository extends JpaRepository<DailyRecord, Long> {
	
	public List<DailyRecord> findByUserId(Long id);
	
	public boolean existsByDateAndUserId(LocalDate date, Long id);
	
	public DailyRecord findByDateAndUserId(LocalDate date, Long id);
	
	
}
