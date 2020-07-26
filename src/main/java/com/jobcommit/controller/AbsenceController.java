package com.jobcommit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobcommit.model.AbsenceRequest;
import com.jobcommit.model.AbsenceVerification;
import com.jobcommit.model.Delay;
import com.jobcommit.model.Notification;
import com.jobcommit.model.User;
import com.jobcommit.repository.AbsenceRequestRepository;
import com.jobcommit.repository.AbsenceVerificationRepository;
import com.jobcommit.repository.DelayRepository;
import com.jobcommit.repository.NotificationRepository;
import com.jobcommit.repository.UserRepository;
import com.jobcommit.security.CustomSecurityAthenticationProvider;

@RestController
@RequestMapping("absence")
public class AbsenceController {

	@Autowired
	public AbsenceRequestRepository absenceRequestRepository;

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public AbsenceVerificationRepository absenceVerificationRepository;

	@Autowired
	public DelayRepository delayRepository;

	@Autowired
	public NotificationRepository notificationRepository;

	@PostMapping("absenceRequest")
	public ResponseEntity<?> addAbsenceRequest(@RequestBody AbsenceRequest body) {

		Optional<User> currentUser = userRepository.findById(CustomSecurityAthenticationProvider.userDetails.getId());

		if (body != null) {

			body.setUser(currentUser.get());

			body.setIsSettled(false);

			body.setAccepted(null);

			absenceRequestRepository.save(body);

			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("absenceVerification")
	public ResponseEntity<?> addAbsenceVerification(@RequestBody AbsenceVerification body) {

		Optional<User> currentUser = userRepository.findById(CustomSecurityAthenticationProvider.userDetails.getId());
		if (body != null) {
			body.setUser(currentUser.get());
			body.setVerified(false);
			absenceVerificationRepository.save(body);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("absences")
	public ResponseEntity<?> getAbsences() {

		Optional<User> currentUser = userRepository.findById(CustomSecurityAthenticationProvider.userDetails.getId());
		List<Delay> delays = delayRepository.findByUserId(currentUser.get().getId());
		return new ResponseEntity<>(delays, HttpStatus.OK);
	}

	@GetMapping("allAbsences")
	public ResponseEntity<?> getAllAbsences() {

		List<Delay> delays = delayRepository.findAll();
		return new ResponseEntity<>(delays, HttpStatus.OK);
	}

	@PutMapping("absences/verifyDelay/{id}")
	public ResponseEntity<?> updatedelay(@RequestBody Delay body, @PathVariable Long id) {

		Optional<User> currentUser = userRepository.findById(CustomSecurityAthenticationProvider.userDetails.getId());
		body.setId(id);
		body.setUser(currentUser.get());
		delayRepository.save(body);

		return new ResponseEntity<>(delayRepository.findByUserId(currentUser.get().getId()), HttpStatus.OK);
	}

	@GetMapping("allAbsencerequests")
	public ResponseEntity<?> getAllAbsenceRequests() {
		return new ResponseEntity<>(absenceRequestRepository.findAll(), HttpStatus.OK);
	}

	@PutMapping("updateRequest")
	public ResponseEntity<?> updateAbsenceRequest(@RequestBody AbsenceRequest body) {

		Notification newNotification = new Notification();
		String notificationMessage = "";
		Optional<User> currentUser = userRepository.findById(CustomSecurityAthenticationProvider.userDetails.getId());

		if (body.getAccepted() == null) {

			notificationMessage = "your manager has requested you to a meeting to disscuss the delay verification you have made  !";
		} else if (body.getAccepted() == false) {

			body.setIsSettled(true);
			notificationMessage = "your delay verification was accepted by the manager !";
		} else if (body.getAccepted() == true) {

			body.setIsSettled(true);
			notificationMessage = "your delay verification was rejected by the manager !";
		}

		newNotification.setMessage(notificationMessage);

		newNotification.setUser(currentUser.get());

		notificationRepository.save(newNotification);

		absenceRequestRepository.save(body);
		return new ResponseEntity<>(absenceRequestRepository.findAll(), HttpStatus.OK);
	}

	// admin layout
	@PutMapping("updateDelay")
	public ResponseEntity<?> updatedelay(@RequestBody Delay body) {

		Notification newNotification = new Notification();
		String notificationMessage = "";
		Optional<User> currentUser = userRepository.findById(CustomSecurityAthenticationProvider.userDetails.getId());

		if (body.getVerified() == null) {
			notificationMessage = "your manager has requested you to a meeting to disscuss the delay verification you have made  !";
		}
		else if (body.getVerified() == true) {
			body.setIsSatteled(true);
			notificationMessage = "your delay verification was accepted by the manager !";
		} else if (body.getVerified() == false) {
			body.setIsSatteled(true);
			notificationMessage = "your delay verification was rejected by the manager !";
		} 

		newNotification.setMessage(notificationMessage);

		newNotification.setUser(currentUser.get());

		notificationRepository.save(newNotification);

		delayRepository.save(body);

		return new ResponseEntity<>(delayRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("allDelays")
	public ResponseEntity<?> getAllDelays() {
		return new ResponseEntity<>(delayRepository.findAll(), HttpStatus.OK);
	}

}
