package com.jobcommit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobcommit.model.CompanyConfiguration;

public interface ConfigurationRepository extends JpaRepository<CompanyConfiguration, Long> {

}
