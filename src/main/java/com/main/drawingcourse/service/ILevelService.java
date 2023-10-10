package com.main.drawingcourse.service;

import com.main.drawingcourse.dto.LevelModel;

import java.util.List;

public interface ILevelService {
    LevelModel AddLevel(LevelModel levelModel);

    List<LevelModel> findAll();
}
