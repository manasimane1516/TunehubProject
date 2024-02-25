package com.example.webapplication.service;

import java.util.List;


import com.example.webapplication.entity.PlayList;
import com.example.webapplication.entity.Songs;

public interface playListService 
{
	
	public void addPlayList(PlayList playlist);

	public List<PlayList> fetchPlayLists();
	
	
	
	
}
