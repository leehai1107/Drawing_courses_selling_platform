package com.main.drawingcourse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.drawingcourse.entity.User;
import com.main.drawingcourse.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
    @Transactional
    public UserDetails loadUserByUsername(String username)  {
        User account = userRepository.findUserByUserName(username);
        if(account==null){
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        return UserDetailsImpl.build(account);
    }
}
