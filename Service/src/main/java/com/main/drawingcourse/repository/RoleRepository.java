package com.main.drawingcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.drawingcourse.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
