package com.jobcommit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobcommit.model.DailyRecord;

public interface PresenceRepository extends JpaRepository<DailyRecord, Long>{

}
