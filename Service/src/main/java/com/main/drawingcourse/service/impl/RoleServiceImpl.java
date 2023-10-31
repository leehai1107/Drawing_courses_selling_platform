package com.main.drawingcourse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.drawingcourse.repository.RoleRepository;
import com.main.drawingcourse.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	RoleRepository roleRepository;
}
