package com.jobcommit.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("users")
public class UserController {
//
//	public UserRepository userRepository;
//
//	@PostMapping("add-employee")
//	public ResponseEntity<?> addEmployee(@RequestBody User user) {
//		user.setRole(Role.EMPLOYEE);
//		this.userRepository.save(user);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//
//	@GetMapping("allEmployees")
//	public ResponseEntity<?> getEmployees() {
//		List<User> employees = this.userRepository.findByRole(Role.EMPLOYEE);
//		return new ResponseEntity<>(employees, HttpStatus.OK);
//	}
//
//	@GetMapping("deleteEmployee/{userID}")
//	public ResponseEntity<?> deleteEmployee(@PathVariable("userID") Long id) {
//		this.userRepository.deleteById(id);
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
//
//	@GetMapping("searchEmployee")
//	public ResponseEntity<?> searchEmployees(@RequestParam("key") String key) {
//		List<User> result = this.userRepository.findByNameContaining(key);
//		return new ResponseEntity<>(result, HttpStatus.OK);
//	}
//
//	@PutMapping("edit-employee/{userID}")
//	public ResponseEntity<?> modifyEmployee(@RequestBody UserUpdateDTO options, @PathVariable("userID") Long id) {
//		Optional<User> employee = this.userRepository.findById(id);
//		if (employee.isPresent()) {
//			if (options.isMarkAsHoliday()) {
//				employee.get().setInHoliday(true);
//			}
//			if (options.isMarkAsRemote()) {
//				employee.get().setRemote(true);
//			}
//			this.userRepository.save(employee.get());
//		}
//		// 204 success no content
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
}