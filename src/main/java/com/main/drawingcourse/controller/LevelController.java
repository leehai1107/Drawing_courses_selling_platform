package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.LevelModel;
import com.main.drawingcourse.repository.LevelRepository;
import com.main.drawingcourse.service.ILevelService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("level")
=======
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/level")
>>>>>>> new/main
public class LevelController {
    @Autowired
    LevelRepository levelRepository;

    @Autowired
    ILevelService levelService;

    @PostMapping(value = "/add")
    public LevelModel AddLevel(@RequestBody LevelModel levelModel){
        return levelService.AddLevel(levelModel);
    }
<<<<<<< HEAD

=======
@GetMapping("/ViewAllLevels")
    public List<LevelModel> findAll() {
        return levelService.findAll();
    }
>>>>>>> new/main
}
