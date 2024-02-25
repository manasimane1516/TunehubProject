package com.example.webapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.webapplication.entity.PlayList;
import com.example.webapplication.entity.Songs;
import com.example.webapplication.repositoy.PlayListRepository;

@Service
public class PlayListServiceImplementation implements playListService 
{
	@Autowired
	PlayListRepository prepo;

	@Override
	public void addPlayList(PlayList playlist)
	{
		prepo.save(playlist);	
	}

	@Override
	public List<PlayList> fetchPlayLists() {
		
		return prepo.findAll();
	}

	
	

	

	

}
