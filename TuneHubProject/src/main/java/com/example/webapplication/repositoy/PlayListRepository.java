package com.example.webapplication.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webapplication.entity.PlayList;
import com.example.webapplication.entity.Songs;

public interface PlayListRepository extends JpaRepository<PlayList,Integer>
{

	

}
