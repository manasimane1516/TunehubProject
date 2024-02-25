package com.example.webapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapplication.entity.Songs;
import com.example.webapplication.repositoy.SongsRepository;


@Service
public class SongsServiceImplemetation implements SongsService
{

	@Autowired
	SongsRepository srepo;

	@Override
	public String addSongs(Songs song) {
		srepo.save(song);
		return "Song is added";
	}

	@Override
	public boolean songExists(String name) {
		Songs song=srepo.findByName(name);
		if(song==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public List<Songs> fetchAllSongs() {
		List<Songs>songslist=srepo.findAll();
		return songslist;
	}

	@Override
	public void updateSong(Songs song) {
		srepo.save(song);
		
	}
	
	

}
