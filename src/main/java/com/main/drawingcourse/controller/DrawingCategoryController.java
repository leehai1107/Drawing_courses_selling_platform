package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.CourseModel;
import com.main.drawingcourse.dto.DrawingCategoryModel;
import com.main.drawingcourse.service.IDrawingCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/category")


public class DrawingCategoryController {
    @Autowired
    IDrawingCategoryService drawingCategoryService;

    @PostMapping(value = "/add")
    public DrawingCategoryModel AddCategory(@RequestBody DrawingCategoryModel drawingCategoryModel) {
        return drawingCategoryService.AddCategory(drawingCategoryModel);
    }

@GetMapping("/ViewAllDrawingCategories")
    public List<DrawingCategoryModel> findAll() {
        return drawingCategoryService.findAll();
    }
}
