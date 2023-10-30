package com.main.drawingcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.drawingcourse.entity.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
	Level findByLevelName(String name);
}
