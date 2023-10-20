package com.main.drawingcourse.controller;

import com.main.drawingcourse.dto.LessonModel;
import com.main.drawingcourse.dto.ResponseLessonByCourseId;
import com.main.drawingcourse.repository.LessonRepository;
import com.main.drawingcourse.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/find-by-course-id/{id}")
    public List<ResponseLessonByCourseId> findLessonsByCourseID(@PathVariable int id){
        return lessonService.findLessonsByCourseID(id);

    }

}
