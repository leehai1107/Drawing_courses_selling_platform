package com.main.drawingcourse.converter;

import org.springframework.stereotype.Component;

import com.main.drawingcourse.dto.LevelModel;
import com.main.drawingcourse.entity.Level;

@Component

public class LevelConverter {
	public Level toEntity(LevelModel levelDto) {
		Level entity = new Level();
		entity.setLevelId(levelDto.getLevelId());
		entity.setLevelName(levelDto.getLevelName());
		return entity;
	}

	public LevelModel toDto(Level levelEntity) {
		LevelModel dto = new LevelModel();
		dto.setLevelId(levelEntity.getLevelId());
		dto.setLevelName(levelEntity.getLevelName());
		return dto;

	}
}
