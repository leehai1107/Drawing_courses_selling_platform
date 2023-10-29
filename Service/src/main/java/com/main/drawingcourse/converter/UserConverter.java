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
		
		entity.setUserId(model.getUserid());
		entity.setUserName(model.getUsername());
		entity.setPassword(model.getPassword());
		entity.setAvatar(model.getAvatar());
		entity.setPhone(model.getPhone());
		entity.setEmail(model.getEmail());
		entity.setRole(roleRepository.getReferenceById(model.getRoleId()));
		entity.setDescription(model.getDescription());
		entity.setStatus(model.isStatus());
		entity.setFullname(model.getFullname());
		entity.setDob(model.getDob());
		entity.setSex(model.getSex());
		
		return entity;
	}

	public UserModel toDto(User entity){
		UserModel dto = new UserModel();
		dto.setUserid(entity.getUserId());
		dto.setUsername(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setAvatar(entity.getAvatar());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setRoleId(entity.getRole().getRoleId());
		dto.setDescription(entity.getDescription());
		dto.setFullname(entity.getFullname());
		dto.setDob(entity.getDob());
		dto.setStatus(entity.isStatus());
		dto.setSex(entity.getSex());
		dto.setRoleModelResponse(roleConverter.toDto(entity.getRole()));
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
