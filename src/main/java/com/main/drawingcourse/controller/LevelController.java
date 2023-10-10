package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.LevelModel;
import com.main.drawingcourse.repository.LevelRepository;
import com.main.drawingcourse.service.ILevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/level")
public class LevelController {
    @Autowired
    LevelRepository levelRepository;

    @Autowired
    ILevelService levelService;

    @PostMapping(value = "/add")
    public LevelModel AddLevel(@RequestBody LevelModel levelModel){
        return levelService.AddLevel(levelModel);
    }
@GetMapping("/ViewAllLevels")
    public List<LevelModel> findAll() {
        return levelService.findAll();
    }
}
