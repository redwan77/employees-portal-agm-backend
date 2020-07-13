package com.jobcommit.controller;

import java.time.Duration;
import java.time.LocalDate;
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
import com.jobcommit.model.Delay;
import com.jobcommit.model.User;
import com.jobcommit.repository.ConfigurationRepository;
import com.jobcommit.repository.DailyRecordRepository;
import com.jobcommit.repository.DelayRepository;
import com.jobcommit.repository.UserRepository;
import com.jobcommit.security.CustomSecurityAthenticationProvider;
import com.jobcommit.service.UserService;
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
	private DailyRecordRepository dailyRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private DelayRepository delayRepository;

	private final int TEST_TIME_OFFSET = 0;

	@PostMapping("entrance")
	public ResponseEntity<?> declareEntrance(@RequestBody EntranceRequest request) {

		CompanyConfiguration configuration = configurationRepository.findById(1l).get();

		Optional<User> currentUser = userRepository.findById(CustomSecurityAthenticationProvider.userDetails.getId());

		request.setRequestTime(LocalTime.now());

		/// try {

		if (request.getLocation() != null && currentUser.isPresent()) {

			double distance = GeolocalizationUtils.distance(request.getLocation().getLatitude(),
					configuration.getLatitude(), request.getLocation().getLongitude(), configuration.getLongitude());

			double AcceptRaduis = configuration.getAcceptRaduis();

			LocalDate currentDate = LocalDate.now();

			// LocalTime exit = (currentDaily.getExitTime());

			// simple conditions
			boolean distanceCondition = distance < AcceptRaduis;

			boolean isNotOutNietherInHoliday = currentUser.get().getIsOut() && !currentUser.get().getIsHoliday();

			boolean timeCondition = request.getRequestTime().minusHours(TEST_TIME_OFFSET)
					.compareTo(configuration.getStartTime()) >= 0
					&& request.getRequestTime().compareTo(configuration.getEndTime()) <= 0;

			boolean isNotRemote = currentUser.get().getIsRemote();

			if ((distanceCondition && isNotOutNietherInHoliday && timeCondition) || isNotRemote) {
				//

				DailyRecord currentDaily = dailyRepository.findByDateAndUserId(currentDate, currentUser.get().getId());

				long delay = ChronoUnit.MINUTES.between(configuration.getStartTime(), request.getRequestTime());

				System.out.println("delay :" + delay);

				if (currentDaily == null) {

					DailyRecord newDaily = new DailyRecord();

					newDaily.setEntranceTime(LocalTime.now());

					newDaily.setWorked(0d);

					newDaily.setBreaks(0);

					newDaily.setUser(currentUser.get());

					newDaily.setEntranceTime(LocalTime.now());

					newDaily.setDate(LocalDate.now());

					newDaily.setLatestEntranceTime(newDaily.getEntranceTime());

					Duration delayDuration = Duration.between(configuration.getStartTime(), LocalTime.now());

					double entranceDelay = (double) delayDuration.getSeconds() / 60;

					newDaily.setDelay(entranceDelay);

					this.dailyRepository.save(newDaily);

					this.userRepository.save(currentUser.get());

					currentDaily = dailyRepository.findByDateAndUserId(currentDate, currentUser.get().getId());

					// create the delay at the entrance moment
					if (delay > configuration.getMargin()) {

						currentDaily.setDelay((double) delay);

						Delay newDelay = new Delay();

						newDelay.setDuration(delay);

						newDelay.setUser(currentUser.get());

						newDelay.setEnd(LocalTime.now());

						newDelay.setStart(configuration.getStartTime());

						newDelay.setIsSatteled(null);

						newDelay.setVerified(null);
						
						newDelay.setDate(LocalDate.now());

						delayRepository.save(newDelay);
					}
				}

				currentUser.get().setIsOut(false);

				currentDaily.setLatestEntranceTime(LocalTime.now());

				currentDaily.setBreaks(currentDaily.getBreaks() + 1);

				/*
				 * save all the changes
				 */
				this.dailyRepository.save(currentDaily);

				this.userRepository.save(currentUser.get());

				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				System.out.println("else1");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} else {
			System.out.println("else2");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		// } catch (Exception e) {

		// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		// }
	}

	@PostMapping("exit")
	public ResponseEntity<?> declareExit(@RequestBody ExitRequest request) {

		CompanyConfiguration configuration = configurationRepository.findById(1l).get();

		Optional<User> currentUser = userRepository.findById(CustomSecurityAthenticationProvider.userDetails.getId());

		request.setRequestTime(LocalTime.now());

		double distance = GeolocalizationUtils.distance(request.getLocation().getLatitude(),
				configuration.getLatitude(), request.getLocation().getLongitude(), configuration.getLongitude());

		double AcceptRaduis = configuration.getAcceptRaduis();

		if (request.getLocation() != null && currentUser.isPresent()) {

			LocalDate currentDate = LocalDate.now();
			LocalTime currentTime = LocalTime.now();

			DailyRecord currentDaily = dailyRepository.findByDateAndUserId(currentDate, currentUser.get().getId());

			if ((!currentUser.get().getIsHoliday() && !currentUser.get().getIsOut() && distance < AcceptRaduis
					&& request.getRequestTime().minusHours(TEST_TIME_OFFSET).compareTo(configuration.getEndTime()) <= 0)
					|| currentUser.get().getIsRemote()) {

				currentUser.get().setIsOut(true);

				if (request.getGolbalExit()) {

					currentDaily.setExitTime(LocalTime.now());

					this.userRepository.save(currentUser.get());

					this.dailyRepository.save(currentDaily);

					return new ResponseEntity<>(HttpStatus.OK);
				}

				currentDaily.setBreaks(currentDaily.getBreaks() + 1);

				/*
				 * we are going to need duration to calculate time in second hence in hours,
				 * instead of "Period"
				 */
				Duration workedDuration = Duration.between(currentDaily.getLatestEntranceTime(), currentTime);

				double worked = (double) workedDuration.getSeconds() / 60;

				currentDaily.setWorked(worked + currentDaily.getWorked());

				this.userRepository.save(currentUser.get());

				this.dailyRepository.save(currentDaily);

				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		// } catch (Exception e) {

		// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		// }
	}

	@PostMapping("location")
	public ResponseEntity<?> declareExit(@RequestBody Location request) {

		return null;
	}

}
