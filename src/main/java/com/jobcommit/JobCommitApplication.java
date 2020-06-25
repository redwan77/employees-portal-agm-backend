package com.jobcommit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobCommitApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobCommitApplication.class, args);
	}

}
