package com.main.drawingcourse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.drawingcourse.dto.UserModel;
import com.main.drawingcourse.entity.User;
import com.main.drawingcourse.repository.RoleRepository;

@Component
public class UserConverter {
	@Autowired
	RoleRepository roleRepository;
	
	public User toEntity(UserModel model) {
		User entity = new User();
		
		entity.setUserId(model.getId());
		entity.setUserName(model.getUserName());
		entity.setPassword(model.getPassword());
		entity.setAvatar(model.getAvatar());
		entity.setRole(roleRepository.getReferenceById(model.getRoleId()));
		entity.setDescription(model.getDescription());
		entity.setStatus(model.getStatus());
		entity.setFullname(model.getFullname());
		
		return entity;
	}

}
