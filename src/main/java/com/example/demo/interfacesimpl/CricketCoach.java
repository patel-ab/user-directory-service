package com.example.demo.interfacesimpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.demo.interfaces.Coach;

@Primary
@Component
public class CricketCoach implements Coach {

	@Override
	public String getCoachName() {
		return "Cricket Coach here";
	}

}
