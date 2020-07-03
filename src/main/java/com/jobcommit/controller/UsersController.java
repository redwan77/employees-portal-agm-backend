package com.jobcommit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobcommit.client_response.UserCreatedSuccess;
import com.jobcommit.dto.UserDTO;
import com.jobcommit.dto.WorkModeConfigurationDTO;
import com.jobcommit.model.Role;
import com.jobcommit.model.User;
import com.jobcommit.repository.UserRepository;
import com.jobcommit.security.CustomSecurityAthenticationProvider;
@CrossOrigin("**")
@RestController
@RequestMapping("users")

public class UsersController {

	@Autowired
	public UserRepository userRepository;

	@PostMapping("addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody UserDTO body) {
		User user = new User();
		user.setAdress(body.getAdress());
		user.setRole(Role.EMPLOYEE);
		user.setName(body.getName());
		user.setEmail(body.getEmail());
		user.setLastName(body.getLastName());
		user.setPhoneNumber(body.getPhoneNumber());
		
		user.setIsRemote(body.getIsRemote());
		user.setIsHoliday(false);
		user.setLogin(body.getEmail());
		user.setPassword(this.alphaNumericString(7));
		this.userRepository.save(user);
		
		
		UserCreatedSuccess reposne = new UserCreatedSuccess();
		reposne.setLogin(body.getEmail());
		reposne.setPassword(this.alphaNumericString(7));

		return new ResponseEntity<>(reposne, HttpStatus.OK);
	}

	@PostMapping("EditEmployeeWorkMode")
	public ResponseEntity<?> EditEmployeeWorkMode(@RequestBody UserDTO body) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("allEmployees")
	public ResponseEntity<?> gettAllEmployees() {

		List<User> employees = this.userRepository.findAll().stream()
				.filter(empl -> empl.getRole().equals(Role.EMPLOYEE)).collect(Collectors.toList());

		List<UserDTO> response = new ArrayList<UserDTO>();
		employees.forEach(empl -> {
			UserDTO dto = new UserDTO();
			dto.setEmail(empl.getEmail());
			dto.setId(empl.getId());
			dto.setName(empl.getName());
			dto.setLastName(empl.getLastName());
			dto.setPhoneNumber(empl.getPhoneNumber());
			
			dto.setIsHoliday(empl.getIsHoliday());
			dto.setIsRemote(empl.getIsRemote());
			response.add(dto);
			System.out.println("the current loged in user is :"+CustomSecurityAthenticationProvider.userDetails.getName());
		});
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PutMapping("updateWorkMode/{idEmployee}")
	public ResponseEntity<?> updateEmployeeWorkMode(@RequestBody WorkModeConfigurationDTO mode,
			@PathVariable("idEmployee") Long id) {

		System.out.println(mode.toString());
		Optional<User> user = this.userRepository.findById(id);
		if (user.isPresent()) {
			user.get().setIsRemote(mode.getIsRemote());
			user.get().setIsHoliday(mode.getIsHoliday());
			this.userRepository.save(user.get());
			// return users with employees role
			// note : this is a very bad way to build things, you should user a service
			// layer to do not repeat code
			// but i have only 2 weeks to finish this thing so ctrl v ctrl c is magic
			List<User> employees = this.userRepository.findAll().stream()
					.filter(empl -> empl.getRole().equals(Role.EMPLOYEE)).collect(Collectors.toList());

			List<UserDTO> response = new ArrayList<UserDTO>();
			employees.forEach(empl -> {
				UserDTO dto = new UserDTO();
				dto.setEmail(empl.getEmail());
				dto.setId(empl.getId());
				dto.setIsHoliday(empl.getIsHoliday());
				dto.setIsRemote(empl.getIsRemote());
				dto.setName(empl.getName());
				dto.setLastName(empl.getLastName());
				dto.setPhoneNumber(empl.getPhoneNumber());
				response.add(dto);
			});
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	@GetMapping("all")
	public List all() {
		return this.userRepository.findAll();
	}

	public String alphaNumericString(int len) {
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}

}
