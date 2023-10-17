package com.main.drawingcourse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.drawingcourse.dto.UserModel;
import com.main.drawingcourse.dto.UserModelRespone;
import com.main.drawingcourse.entity.User;
import com.main.drawingcourse.repository.RoleRepository;

@Component
public class UserConverter {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	RoleConverter roleConverter;
	
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
		entity.setDob(model.getDob());
		entity.setStatus(model.getStatus());
		entity.setSex(model.isSex());
		
		return entity;
	}

	public UserModel toDto(User entity){
		UserModel dto = new UserModel();
		dto.setId(entity.getUserId());
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setAvatar(entity.getAvatar());
		dto.setRoleId(entity.getRole().getRoleId());
		dto.setDescription(entity.getDescription());
		dto.setFullname(entity.getFullname());
		dto.setDob(entity.getDob());
		dto.setStatus(entity.getStatus());
		dto.setSex(entity.getSex());
		return dto;
	}
	
	public UserModelRespone toResponse(User entity){
		UserModelRespone dto = new UserModelRespone();
		dto.setId(entity.getUserId());
		dto.setRoleInfo(roleConverter.toDto(entity.getRole()));
		dto.setFullname(entity.getFullname());
		return dto;
	}

}
