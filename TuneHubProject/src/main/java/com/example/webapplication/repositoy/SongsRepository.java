package com.example.webapplication.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webapplication.entity.Songs;

public interface SongsRepository extends JpaRepository<Songs,Integer>
{
	public Songs findByName(String name);

}
