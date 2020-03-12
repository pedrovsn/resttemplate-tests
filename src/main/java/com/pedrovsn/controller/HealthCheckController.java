package com.pedrovsn.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HealthCheckController {

	private static final Map<String, String> status = ImmutableMap.of("status", "up");

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> root(){
		return status;
	}

	@GetMapping("health")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> health(){
		return status;
	}
}
