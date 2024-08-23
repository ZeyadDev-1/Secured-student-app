package com.ziad.SpringSecEx.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ziad.SpringSecEx.moudle.UserPrinciple;
import com.ziad.SpringSecEx.moudle.Users;
import com.ziad.SpringSecEx.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	private UserRepo repo;
	public MyUserDetailsService(UserRepo repo) {
		super();
		this.repo = repo;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = repo.findByUsername(username);
		
		if(user == null) {
			System.out.println("not found");
			throw new UsernameNotFoundException("not found");
		}
		
		return new UserPrinciple(user);
	}

}
