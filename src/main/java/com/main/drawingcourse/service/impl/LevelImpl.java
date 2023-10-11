package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.LevelConverter;
import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.LevelModel;
import com.main.drawingcourse.entity.Level;
import com.main.drawingcourse.repository.LevelRepository;
import com.main.drawingcourse.service.ILevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.util.List;
import java.util.stream.Collectors;

>>>>>>> update/main
@Service

public class LevelImpl implements ILevelService {
    @Autowired
    LevelRepository levelRepository;
    @Autowired
    LevelConverter levelConverter;


    @Override
    public LevelModel AddLevel(LevelModel levelModel) {
        Level levelEntity = levelConverter.toEntity(levelModel);
        levelEntity = levelRepository.save(levelEntity);

        return levelConverter.toDto(levelEntity);
    }
<<<<<<< HEAD
=======

    public List<LevelModel> findAll() {
        List<LevelModel> levels = levelRepository.findAll().stream()
                .map(levelConverter::toDto)
                .collect(Collectors.toList());

        return levels;
    }
>>>>>>> update/main
}
