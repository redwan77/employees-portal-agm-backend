package com.jobcommit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobcommit.model.DailyRecord;

public interface DailyRepository extends JpaRepository<DailyRecord,Long> {

}
