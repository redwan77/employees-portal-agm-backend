package com.jobcommit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jobcommit.repository.ConfigurationRepository;

@Component
public class ConfigurationService {
	@Autowired
	public static ConfigurationRepository configurationRepository;
	
	public static Float getTheoricalDailyWorkedTime() {
		return configurationRepository.findById(1l).get().getTheoricalDailyWorkedTime();
	}
	
	public static Float getTheoricalWeeklyWorkedTime() {
		return configurationRepository.findById(1l).get().getTheoricalWeeklyWorkedTime();
	}
	
	public static Float getTheoricalMonthlyWorkedTime() {
		return configurationRepository.findById(1l).get().getTheoricalMonthlyWorkedTime();
	}

}
