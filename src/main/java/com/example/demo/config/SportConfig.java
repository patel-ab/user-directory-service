package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.interfacesimpl.FootballCoach;

@Configuration
public class SportConfig {
	
	@Bean("FootballCoach")
	public FootballCoach footballcoachbeanmethod() {
		return new FootballCoach();
	}

}
