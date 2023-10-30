package com.main.drawingcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.drawingcourse.dto.DrawingCategoryModel;
import com.main.drawingcourse.service.IDrawingCategoryService;

@RestController
@RequestMapping("public/courseCategory")

public class DrawingCategoryController {
	@Autowired
	IDrawingCategoryService drawingCategoryService;

	@PostMapping(value = "/addCategory")
	public DrawingCategoryModel AddCategory(@RequestBody DrawingCategoryModel drawingCategoryModel) {
		return drawingCategoryService.AddCategory(drawingCategoryModel);
	}

	@GetMapping("/ViewAllDrawingCategories")
	public List<DrawingCategoryModel> findAll() {
		return drawingCategoryService.findAll();
	}
}
