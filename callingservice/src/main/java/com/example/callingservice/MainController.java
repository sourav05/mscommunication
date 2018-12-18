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
//		System.out.println("DISCOVERY_CLIENT ***********  " + this.discoveryClient);
//		System.out.println("this.discoveryClient.getInstances('add-service') = " + this.discoveryClient.getInstances("add-service"));
		ResponseEntity<String> response = template.getForEntity("http://add-service/add/" + number1 + "/" + number2, String.class);
		return response.getBody();
	}
	
	@GetMapping("sub/{num1}/{num2}")
	public String substract(@PathVariable(value="num1") int number1, @PathVariable(value="num2") int number2){
		/*ResponseEntity<String> response = template.getForEntity(this.discoveryClient.getInstances("SubstractService")
																	.get(0).getUri() + "/sub/" + number1 + "/" + number2, String.class);*/
		
		ResponseEntity<String> response = template.getForEntity("http://sub-service" + "/sub/" + number1 + "/" + number2, String.class);
		
		return response.getBody();
	}
	
	@GetMapping("mult/{num1}/{num2}")
	public String multiply(@PathVariable(value="num1") int number1, @PathVariable(value="num2") int number2){
		ResponseEntity<String> response = template.getForEntity("http://multi-service" + "/mult/" + number1 + "/" + number2, String.class);
		return response.getBody();
	}
	
	@GetMapping("div/{num1}/{num2}")
	public String division(@PathVariable(value="num1") int number1, @PathVariable(value="num2") int number2){
		ResponseEntity<String> response = template.getForEntity("http://div-service" + "/div/" + number1 + "/" + number2, String.class);
		return response.getBody();
	}
	
}
