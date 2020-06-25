package com.jobcommit.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ScheduleTasks {

	//@Scheduled(cron="0 5 14 * * *")
	@Scheduled(fixedRate = 1000)
	public void test() {
		System.out.println("hello");
	}
}
