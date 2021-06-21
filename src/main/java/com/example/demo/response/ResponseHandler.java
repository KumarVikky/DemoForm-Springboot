package com.example.demo.response;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
		
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
		Map<String, Object> dataTransmitter = new HashMap<String, Object>();
		dataTransmitter.put("timestamp", new Date());
		dataTransmitter.put("message", message);
		dataTransmitter.put("status", status.value());
		dataTransmitter.put("data", responseObj);
		return new ResponseEntity<Object>(dataTransmitter, status);
	}
}
