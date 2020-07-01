package com.jobcommit.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobcommit.dto.LocationConfigurationDTO;
import com.jobcommit.dto.TimingConfigurationDTO;
import com.jobcommit.dto.WorkModeConfigurationDTO;
import com.jobcommit.model.CompanyConfiguration;
import com.jobcommit.repository.ConfigurationRepository;

@RestController
@RequestMapping("configuration")
@CrossOrigin("**")
public class ConfigurationController {

	@Autowired
	public ConfigurationRepository configRepository;

	@PatchMapping("timing-configuration")
	public ResponseEntity<?> setTimingConfig(@RequestBody TimingConfigurationDTO config) {
		Optional<CompanyConfiguration> configuration = this.configRepository.findById(1l);
		if (!configuration.isPresent()) {
			CompanyConfiguration newConfig = new CompanyConfiguration();
			newConfig.setEndTime(config.getEndTime());
			newConfig.setStartTime(config.getStartTime());
			newConfig.setMargin(config.getMargin());
			newConfig.setMarginActivated(config.getIsMarginActivated());
			newConfig.setTheoricalDailyWorkedTime(config.getTheoricalDailyWorkedTime());
			newConfig.setTheoricalMonthlyWorkedTime(config.getTheoricalMonthlyWorkedTime());
			newConfig.setTheoricalWeeklyWorkedTime(config.getTheoricalWeeklyWorkedTime());
			this.configRepository.save(newConfig);
		} else {
			configuration.get().setEndTime(config.getEndTime());
			configuration.get().setStartTime(config.getStartTime());
			configuration.get().setMargin(config.getMargin());
			configuration.get().setMarginActivated(config.getIsMarginActivated());
			configuration.get().setTheoricalDailyWorkedTime(config.getTheoricalDailyWorkedTime());
			configuration.get().setTheoricalMonthlyWorkedTime(config.getTheoricalMonthlyWorkedTime());
			configuration.get().setTheoricalWeeklyWorkedTime(config.getTheoricalWeeklyWorkedTime());
			this.configRepository.save(configuration.get());
		}
		TimingConfigurationDTO response = new TimingConfigurationDTO();
		Optional<CompanyConfiguration> configurationResponse = this.configRepository.findById(1l);

		response.setEndTime(configurationResponse.get().getEndTime());
		response.setStartTime(configurationResponse.get().getStartTime());
		response.setMargin(configurationResponse.get().getMargin());
		response.setIsMarginActivated(configurationResponse.get().isMarginActivated());
		response.setTheoricalDailyWorkedTime(configurationResponse.get().getTheoricalDailyWorkedTime());
		response.setTheoricalMonthlyWorkedTime(configurationResponse.get().getTheoricalMonthlyWorkedTime());
		response.setTheoricalWeeklyWorkedTime(configurationResponse.get().getTheoricalWeeklyWorkedTime());
		return new ResponseEntity<TimingConfigurationDTO>(response, HttpStatus.OK);
	}

	@PatchMapping("localisation-configuration")
	public ResponseEntity<?> setLocalisationConfig(@RequestBody LocationConfigurationDTO config) {
		Optional<CompanyConfiguration> configuration = this.configRepository.findById(1l);
		if (!configuration.isPresent()) {
			CompanyConfiguration newConfig = new CompanyConfiguration();
			newConfig.setAcceptRaduis(config.getDistance());
			newConfig.setLatitude(config.getAtitude());
			newConfig.setLongitude(config.getLangitude());
			this.configRepository.save(newConfig);
		} else {
			configuration.get().setAcceptRaduis(config.getDistance());
			configuration.get().setLatitude(config.getAtitude());
			configuration.get().setLongitude(config.getLangitude());
			this.configRepository.save(configuration.get());
		}

		LocationConfigurationDTO response = new LocationConfigurationDTO();
		Optional<CompanyConfiguration> configurationResponse = this.configRepository.findById(1l);
		response.setDistance(configurationResponse.get().getAcceptRaduis());
		response.setAtitude(configurationResponse.get().getLatitude());
		response.setLangitude(configurationResponse.get().getLongitude());
		return new ResponseEntity<LocationConfigurationDTO>(response, HttpStatus.OK);
	}

	@PatchMapping("workMode-configuration")
	public ResponseEntity<?> setWorkModeConfig(@RequestBody WorkModeConfigurationDTO config) {
		System.out.println(config);
		Optional<CompanyConfiguration> configuration = this.configRepository.findById(1l);
		if (!configuration.isPresent()) {
			CompanyConfiguration newConfig = new CompanyConfiguration();
			newConfig.setRemoteMode(config.getIsRemote());
			newConfig.setHolidayMode(config.getIsHoliday());
			this.configRepository.save(newConfig);
		} else {
			configuration.get().setRemoteMode(config.getIsRemote());
			configuration.get().setHolidayMode(config.getIsHoliday());
			this.configRepository.save(configuration.get());
		}
		WorkModeConfigurationDTO response = new WorkModeConfigurationDTO();
		Optional<CompanyConfiguration> configurationResponse = this.configRepository.findById(1l);

		response.setIsRemote(configurationResponse.get().isRemoteMode());
		response.setIsHoliday(configurationResponse.get().isHolidayMode());
		return new ResponseEntity<WorkModeConfigurationDTO>(response, HttpStatus.OK);
	}

	@GetMapping("geoLocalizationData")
	public ResponseEntity<LocationConfigurationDTO> getGeoData() {
		LocationConfigurationDTO response = new LocationConfigurationDTO();
		Optional<CompanyConfiguration> configurationResponse = this.configRepository.findById(1l);
		if (configurationResponse.isPresent()) {
			response.setDistance(configurationResponse.get().getAcceptRaduis());
			response.setAtitude(configurationResponse.get().getLatitude());
			response.setLangitude(configurationResponse.get().getLongitude());
		}
		return new ResponseEntity<LocationConfigurationDTO>(response, HttpStatus.OK);
	}

	@GetMapping("timingData")
	public ResponseEntity<TimingConfigurationDTO> getTimingData() {
		TimingConfigurationDTO response = new TimingConfigurationDTO();
		Optional<CompanyConfiguration> configurationResponse = this.configRepository.findById(1l);
		if (configurationResponse.isPresent()) {
			response.setEndTime(configurationResponse.get().getEndTime());
			response.setStartTime(configurationResponse.get().getStartTime());
			response.setMargin(configurationResponse.get().getMargin());
			response.setIsMarginActivated(configurationResponse.get().isMarginActivated());
			response.setTheoricalDailyWorkedTime(configurationResponse.get().getTheoricalDailyWorkedTime());
			response.setTheoricalMonthlyWorkedTime(configurationResponse.get().getTheoricalMonthlyWorkedTime());
			response.setTheoricalWeeklyWorkedTime(configurationResponse.get().getTheoricalWeeklyWorkedTime());
		}
		return new ResponseEntity<TimingConfigurationDTO>(response, HttpStatus.OK);
	}

	@GetMapping("workData")
	public ResponseEntity<WorkModeConfigurationDTO> getWorkData(){
		WorkModeConfigurationDTO response = new WorkModeConfigurationDTO();
		Optional<CompanyConfiguration> configurationResponse = this.configRepository.findById(1l);
		if(configurationResponse.isPresent()) {
			response.setIsRemote(configurationResponse.get().isRemoteMode());
			response.setIsHoliday(configurationResponse.get().isHolidayMode());
		}
		return new ResponseEntity<WorkModeConfigurationDTO>(response, HttpStatus.OK);
	}

}
