package com.main.drawingcourse.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.drawingcourse.converter.LevelConverter;
import com.main.drawingcourse.dto.LevelModel;
import com.main.drawingcourse.entity.Level;
import com.main.drawingcourse.repository.LevelRepository;
import com.main.drawingcourse.service.ILevelService;

@Service

public class LevelImpl implements ILevelService {
	@Autowired
	LevelRepository levelRepository;
	@Autowired
	LevelConverter levelConverter;

	@Override
	public LevelModel AddLevel(LevelModel levelModel) {

		Level existingLevel = levelRepository.findByLevelName(levelModel.getLevelName());
		if (existingLevel != null) {
			throw new IllegalArgumentException("Level name is already exists");
		}

		Level levelEntity = levelConverter.toEntity(levelModel);
		levelEntity = levelRepository.save(levelEntity);

		return levelConverter.toDto(levelEntity);
	}

	@Override
	public List<LevelModel> findAll() {
		List<LevelModel> levels = levelRepository.findAll().stream().map(levelConverter::toDto)
				.collect(Collectors.toList());

		return levels;
	}

}
