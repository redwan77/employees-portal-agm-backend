package com.jobcommit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("absence")
public class AbsenceController {

	@PostMapping("absenceRequest")
	public  ResponseEntity<?> addAbsenceRequest(@RequestBody Object s){
		return null ;
	}
}
