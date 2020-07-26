package com.jobcommit.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(1)
public class CorsFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		/*
		 * add CORS configuration headers to the response so that the navigator does not
		 * consider that the request was rejected by CORS policy
		 */

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, PATCH ");
		response.setHeader("Access-Control-Max-Age", "4000");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		// if the request is a PREFLIGHT CORS request approve the headers else continue processing 
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(201);
			//System.out.println("From cors filter :" + request.getMethod());
		}
		else 
		filterChain.doFilter(request, response);

	}

}
