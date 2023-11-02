package com.demoproj.todos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproj.todos.Constant;
import com.demoproj.todos.auth.AuthenticationBean;


@CrossOrigin(Constant.CROSS_ORIGIN_URL)
@RestController
public class AuthController {
	
	@GetMapping(path = "/basicauth")
	public AuthenticationBean authenticate() {
		return new AuthenticationBean("You are Authenticated!!");
	}

}
