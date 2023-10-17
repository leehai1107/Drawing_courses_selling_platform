package com.main.drawingcourse.converter;

import org.springframework.stereotype.Component;

import com.main.drawingcourse.dto.RoleModelResponse;
import com.main.drawingcourse.entity.Role;



@Component
public class RoleConverter {
    public RoleModelResponse toDto(Role role){
    	RoleModelResponse dto = new RoleModelResponse();
        dto.setRoleId(role.getRoleId());
        dto.setRoleName(role.getRoleName());
        return dto;
    }

}
