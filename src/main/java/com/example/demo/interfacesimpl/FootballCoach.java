package com.example.demo.interfacesimpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.interfaces.Coach;

@Configuration
public class FootballCoach implements Coach {

	@Override
	public String getCoachName() {
		return "This is football coach";
	}

}
