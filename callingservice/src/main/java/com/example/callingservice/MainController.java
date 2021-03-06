package com.example.callingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

	/*@Autowired
	private DiscoveryClient discoveryClient;*/
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("add/{num1}/{num2}")
	public String add(@PathVariable(value="num1") int number1, @PathVariable(value="num2") int number2){
//		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.getForEntity("http://add-service/add/" + number1 + "/" + number2, String.class);
		return response.getBody();
	}
}
