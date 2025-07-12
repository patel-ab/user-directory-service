package com.example.demo.interfacesimpl;

import org.springframework.stereotype.Component;

import com.example.demo.interfaces.Player;

@Component
public class CricketPlayer implements Player {

	@Override
	public String getPlayerName() {
		
		return "This is Cricket Player";
	}

}
