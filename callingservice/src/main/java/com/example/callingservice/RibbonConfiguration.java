package com.example.callingservice;

import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

public class RibbonConfiguration {

	@Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RoundRobinRule();
    }
}
