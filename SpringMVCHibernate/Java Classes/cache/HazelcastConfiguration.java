package com.ebanks.springapp.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;

@Configuration
public class HazelcastConfiguration {

	@Bean
	public Config config() {
		return new Config(); // Set up any non-default config here
	}
}