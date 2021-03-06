package com.example.callingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClients({@RibbonClient(name="add-service", configuration = RibbonConfiguration.class),
	@RibbonClient(name="sub-service", configuration = RibbonConfiguration.class),
	@RibbonClient(name="multi-service", configuration = RibbonConfiguration.class),
	@RibbonClient(name="div-service", configuration = RibbonConfiguration.class)})
public class CallingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallingserviceApplication.class, args);
	}

}

