package com.example.webapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NavController
{
	@PostMapping("/map-register")
	public String registerMapping()
	{
		return "register";
		
	}
	
	@GetMapping("/map-login")
	public String loginMapping()
	{
		return "login";
	}
	
	@GetMapping("/map-songs")
	public String songMapping()
	{
		return "addsongs";
	}
	
	@GetMapping("/Payment")
	public String samplePayment()
	{
		return "Payment";
	}
	

}
