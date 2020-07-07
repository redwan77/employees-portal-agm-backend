package com.jobcommit.controller;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobcommit.model.CompanyConfiguration;
import com.jobcommit.model.DailyRecord;
import com.jobcommit.model.User;
import com.jobcommit.repository.ConfigurationRepository;
import com.jobcommit.repository.DailyRepository;
import com.jobcommit.repository.UserRepository;
import com.jobcommit.security.CustomSecurityAthenticationProvider;
import com.jobcommit.user_requests.EntranceRequest;
import com.jobcommit.user_requests.ExitRequest;
import com.jobcommit.user_requests.Location;
import com.jobcommit.utils.GeolocalizationUtils;

@RestController
@RequestMapping("presence")
public class PresenceController {

	@Autowired
	private ConfigurationRepository configurationRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DailyRepository dailyRepository;

	@PostMapping("entrance")
	public ResponseEntity<?> declareEntrance(@RequestBody EntranceRequest request) {

		CompanyConfiguration configuration = configurationRepository.findById(1l).get();

		Optional<User> currentUser = userRepository.findById(CustomSecurityAthenticationProvider.userDetails.getId());

		request.setRequestTime(LocalTime.now());

		try {

			if (request.getLocation() != null && currentUser.isPresent()) {

				double distance = GeolocalizationUtils.distance(request.getLocation().getLatitude(),
						configuration.getLatitude(), request.getLocation().getLongitude(),
						configuration.getLongitude());

				double AcceptRaduis = configuration.getAcceptRaduis();

//				System.out.println("distance :" + distance);
//
//				System.out.println("is out :" + currentUser.get().getIsOut());
//
//				System.out.println("is holiday :" + currentUser.get().getIsHoliday());
//
//				System.out.println(
//						"time diffirence :" + request.getRequestTime().compareTo(configuration.getStartTime()));
//
//				System.out.println("accept radius :" + AcceptRaduis);

				if (distance < AcceptRaduis && currentUser.get().getIsOut() && !currentUser.get().getIsHoliday()
				/*
				 * WARNING : ADDED 3 HOURES DIFFIRENCE FOR TESTING PERPUSES
				 */
						&& request.getRequestTime().minusHours(3).compareTo(configuration.getStartTime()) >= 0) {
					// && request.getRequestTime().compareTo(configuration.getEndTime()) <= 0

					// start a new daily record
					DailyRecord newDaily = new DailyRecord();

					newDaily.setEntranceTime(LocalTime.now());

					newDaily.setWorked(0d);

					long delay = ChronoUnit.MINUTES.between(request.getRequestTime(), configuration.getStartTime());

					if (delay > configuration.getMargin()) {

						newDaily.setDelay((double) delay);
					}
					currentUser.get().setIsOut(false);
					
					this.dailyRepository.save(newDaily);
				
					this.userRepository.save(currentUser.get());

					return new ResponseEntity<>(HttpStatus.OK);
				}
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				
			} else {

				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("exit")
	public ResponseEntity<?> declareExit(@RequestBody ExitRequest request) {
		
		CompanyConfiguration configuration = configurationRepository.findById(1l).get();

		Optional<User> currentUser = userRepository.findById(CustomSecurityAthenticationProvider.userDetails.getId());

		request.setRequestTime(LocalTime.now());
		
		double distance = GeolocalizationUtils.distance(request.getLocation().getLatitude(),
				configuration.getLatitude(), request.getLocation().getLongitude(),
				configuration.getLongitude());

		double AcceptRaduis = configuration.getAcceptRaduis();
		
		if (
				!currentUser.get().getIsHoliday() &&
				distance < AcceptRaduis && 
				request.getRequestTime().compareTo(configuration.getEndTime()) >= 0 ) {
			
			System.out.println("exit is success");
		}
		return null;
	}

	@PostMapping("location")
	public ResponseEntity<?> declareExit(@RequestBody Location request) {

		System.out.println("+++++++ " + request);
		return null;
	}

}
