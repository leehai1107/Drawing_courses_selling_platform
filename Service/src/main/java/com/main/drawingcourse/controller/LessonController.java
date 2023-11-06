package com.main.drawingcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.drawingcourse.dto.LessonModel;
import com.main.drawingcourse.dto.ResponseLessonByCourseId;
import com.main.drawingcourse.repository.LessonRepository;
import com.main.drawingcourse.service.ILessonService;

@RestController
@RequestMapping("public/lesson")
public class LessonController {

	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	ILessonService lessonService;

	@PostMapping("/add")
	public LessonModel AddLesson(@RequestBody LessonModel lessonModel) {

		return lessonService.AddLesson(lessonModel);
	}

	@GetMapping(value = "/find-by-course-id/{id}")
	public List<ResponseLessonByCourseId> findLessonsByCourseID(@PathVariable int id) {
		return lessonService.findLessonsByCourseID(id);

	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<?> editLesson(@RequestBody List<LessonModel> list){
		lessonService.editLesson(list);
		return ResponseEntity.ok("Edit success");
	}

}
