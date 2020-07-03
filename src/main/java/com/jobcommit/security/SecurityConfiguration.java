package com.jobcommit.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

import com.jobcommit.security.filters.AuthenticationFilter;
import com.jobcommit.security.filters.CorsFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	// allow all requests
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/").permitAll();
		http.addFilterBefore(new AuthenticationFilter(), SecurityContextPersistenceFilter.class);
		http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
		//new AuthenticationFilter()
	}
}
