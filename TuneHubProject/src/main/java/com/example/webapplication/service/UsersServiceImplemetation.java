package com.example.webapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapplication.entity.Users;
import com.example.webapplication.repositoy.UsersRepository;

@Service
public class UsersServiceImplemetation implements UsersService 
{
	@Autowired
	UsersRepository userepo;
	

	@Override
	public String addUser(Users user) {
		userepo.save(user);
		return "User objectt is created or saved ";
	}


	@Override
	public boolean emailExists(String email)
	{
	if(userepo.findByEmail(email)== null)
	{
		return false;
	}
	else
	{
		return true;
	}

}

	@Override
	public boolean validateUser(String email, String password)
	{
		
		Users user=userepo.findByEmail(email);
		String db_password=user.getPassword();
		
		if(db_password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public String getRole(String email) {
		return (userepo.findByEmail(email).getRole());
	}


	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return userepo.findByEmail(email);
	}


	@Override
	public void updateUser(Users user) 
	{
			userepo.save(user);
		
	}

}
