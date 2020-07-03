package com.jobcommit.security.filters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.jobcommit.security.CustomBasicAutheticationUserCredentials;
import com.jobcommit.security.CustomSecurityAthenticationProvider;

public class AuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authorization = request.getHeader("Authorization");

		System.out.println("URL :" + request.getRequestURL());
		System.out.println("URI :" + request.getRequestURI());

		if (request.getRequestURI().contentEquals("/login")) {
			filterChain.doFilter(request, response);
		}
		else if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
			// Authorization: Basic base64credentials
			String base64Credentials = authorization.substring("Basic".length()).trim();
			byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
			String credentials = new String(credDecoded, StandardCharsets.UTF_8);
			// credentials = username:password
			final String[] values = credentials.split(":", 2);

			CustomBasicAutheticationUserCredentials ucredentials = new CustomBasicAutheticationUserCredentials();
			ucredentials.setLogin(values[0]);
			ucredentials.setPassword(values[1]);
			if (CustomSecurityAthenticationProvider.authenticate(ucredentials)) {
				System.out.println("yess");
				
				filterChain.doFilter(request, response);
			} else {
				response.sendError(401);
			}
		} else {
			response.sendError(401);
		}

	}

}
