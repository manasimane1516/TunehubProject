package com.example.webapplication.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webapplication.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> 
{
	public Users findByEmail(String email);
}
