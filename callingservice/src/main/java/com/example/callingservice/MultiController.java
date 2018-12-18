package com.example.callingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MultiController {
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("mult/{num1}/{num2}")
	public String multiply(@PathVariable(value="num1") int number1, @PathVariable(value="num2") int number2){
		ResponseEntity<String> response = template.getForEntity("http://multi-service" + "/mult/" + number1 + "/" + number2, String.class);
		return response.getBody();
	}
}
