package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.Coach;
import com.example.demo.interfaces.Player;

@RestController
public class BasicController {

	
	private Coach coach;
	private Player player;
	
	@Autowired
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@Autowired
	BasicController(@Qualifier("FootballCoach")Coach coach){
		this.coach = coach;
		
	}
	
	@Value("${spring.application.name}")
	private String name;


	@GetMapping("/")
	public String sayHello() {
		return name;
	}
	

	
	@GetMapping("/getcoach")
	public String printCoachName() {
		return coach.getCoachName();
	}
	
	
	@GetMapping("/getplayer")
	public String workOut() {
		return player.getPlayerName();
	}

}
