package com.example.webapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webapplication.entity.PlayList;
import com.example.webapplication.entity.Songs;
import com.example.webapplication.service.SongsService;
import com.example.webapplication.service.playListService;

@Controller
public class PlayListController
{
	@Autowired
	playListService pserv;
	
	@Autowired
	SongsService sserv;
	
	@GetMapping("/createplaylist")
	public String createPlayList(Model model)
	{
		//fetching the songs using song service
		List<Songs>songslist=sserv.fetchAllSongs();
		
		//Adding the songs in the model
		model.addAttribute("songslist", songslist);
		
		//sending control to Createplaylist
		return "createplaylist";
		
	}
	
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist)
	{
		pserv.addPlayList(playlist);
		List<Songs>songslist=playlist.getSongs();
		for(Songs song:songslist)
		{
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		return "playlistsuccess";
	}
	
	@GetMapping("/viewPlaylists")
	public String viewPlayllist(Model model)
	{
		List<PlayList> plist=pserv.fetchPlayLists();
		model.addAttribute("plist", plist);
		return "viewPlaylists";
	}
	

}
