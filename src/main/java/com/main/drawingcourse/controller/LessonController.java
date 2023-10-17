package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.LessonModel;
import com.main.drawingcourse.repository.LessonRepository;
import com.main.drawingcourse.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/lesson")
public class LessonController {

    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    ILessonService lessonService;


    @PostMapping("/add")
    public LessonModel AddLesson (@RequestBody LessonModel lessonModel) {

        return lessonService.AddLesson(lessonModel);
    }

}
