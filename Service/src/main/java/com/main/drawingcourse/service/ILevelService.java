package com.main.drawingcourse.service;

import java.util.List;

import com.main.drawingcourse.dto.LevelModel;

public interface ILevelService {
	LevelModel AddLevel(LevelModel levelModel);

	List<LevelModel> findAll();

}
