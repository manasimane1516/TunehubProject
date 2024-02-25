package com.example.webapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.webapplication.entity.Songs;
import com.example.webapplication.entity.Users;
import com.example.webapplication.service.SongsService;
import com.example.webapplication.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController 
{
	@Autowired
	UsersService userv;
	
	@Autowired
	SongsService songserv;
	@GetMapping("/map-register")
	
	public String registerMapping()
	{
		return "register";
	}
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user)
	{
		boolean userstetus=userv.emailExists(user.getEmail());
		if(userstetus == false)
		{
			
			userv.addUser(user);
			return "registersuccess";
		}
		else
		{
			return "registerfail";
		}
		
		
	}
	
	
	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password,HttpSession session) {
		
		
		if(userv.validateUser(email, password)== true)
		{
			session.setAttribute("email", email);
			if(userv.getRole(email).equals("admin"))
			{
				return "adminhome";
			}
			else
			{
				return "customerhome";
			}
		}
		else
		{
			return "loginfail";
		}
	}
	
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session ,Model model)
	{
		String email=(String)session.getAttribute("email");
		Users user=userv.getUser(email);
		boolean userStetus=user.isPrimium();
			if(userStetus==true)
			{
				List<Songs> songslist = songserv.fetchAllSongs();
				model.addAttribute("songslist", songslist);
				return "displaysongs";
			}
			else
			{
				return "Payment";
			}
		
	}
}
