package com.main.drawingcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.drawingcourse.dto.LevelModel;
import com.main.drawingcourse.repository.LevelRepository;
import com.main.drawingcourse.service.ILevelService;

@RestController
@RequestMapping("public/level")

public class LevelController {
	@Autowired
	LevelRepository levelRepository;

	@Autowired
	ILevelService levelService;

	@PostMapping(value = "/addLevel")
	public LevelModel AddLevel(@RequestBody LevelModel levelModel) {
		return levelService.AddLevel(levelModel);
	}

	@GetMapping("/ViewAllLevels")
	public List<LevelModel> findAll() {

		return levelService.findAll();
	}

}
