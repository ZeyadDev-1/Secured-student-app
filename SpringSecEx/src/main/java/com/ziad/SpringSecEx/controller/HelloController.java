package com.ziad.SpringSecEx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

	@GetMapping("/session")
	public String great(HttpServletRequest request) {
		System.out.println("working");
		return"The ID:" + request.getSession().getId();
		
	}
}
