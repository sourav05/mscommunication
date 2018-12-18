package com.example.callingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SubController {

	/*@Autowired
	private DiscoveryClient discoveryClient;*/
	
	@Autowired
	private RestTemplate template;

	@GetMapping("sub/{num1}/{num2}")
	public String substract(@PathVariable(value="num1") int number1, @PathVariable(value="num2") int number2){
//		RestTemplate template = new RestTemplate();
		/*ResponseEntity<String> response = template.getForEntity(this.discoveryClient.getInstances("SubstractService")
																	.get(0).getUri() + "/sub/" + number1 + "/" + number2, String.class);*/
		
		ResponseEntity<String> response = template.getForEntity("http://sub-service" + "/sub/" + number1 + "/" + number2, String.class);
		
		return response.getBody();
	}
}
