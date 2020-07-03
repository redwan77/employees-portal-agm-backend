package com.jobcommit.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CorsFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println("cors executed");
		// add CORS configuration headers to the response so that the navigator does not
				// consider that the request was
				// rejected by CORS policy
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
				response.setHeader("Access-Control-Max-Age", "4000");
				response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type ,authorization , **");
				// response.setHeader("Access-Control-Allow-Credentials", "true");
				filterChain.doFilter(request, response);
		
	}

}
