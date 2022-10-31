package com.ebit.springsecurityproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.springsecurityproject.entity.AuthReq;
import com.ebit.springsecurityproject.util.JwtUtil;

@RestController("/")
public class UserController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("")
	public String getMessage() {

		return "hello";
	}

	@PostMapping("authenticate")
	public String genrateToken(@RequestBody AuthReq authReq) throws Exception {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUserName(), authReq.getPass()));

		} catch (Exception e) {
			throw new Exception("Invalid UserName/Password");
		}
		return jwtUtil.generateToken(authReq.getUserName());

	}
}
