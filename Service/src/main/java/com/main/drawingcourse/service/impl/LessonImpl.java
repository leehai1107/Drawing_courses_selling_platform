package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.dto.ResponseLessonByCourseId;
import com.main.drawingcourse.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.drawingcourse.converter.LessonConverter;
import com.main.drawingcourse.dto.LessonModel;
import com.main.drawingcourse.entity.Lesson;
import com.main.drawingcourse.repository.LessonRepository;
import com.main.drawingcourse.service.ILessonService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonImpl implements ILessonService {


    @Autowired
    LessonConverter lessonConverter;

    @Autowired
    LessonRepository lessonRepository;

    public LessonModel AddLesson (LessonModel lessonModel) {
        Lesson lessonEntity = lessonConverter.toEntity(lessonModel);
        lessonEntity = lessonRepository.save(lessonEntity);

        return lessonConverter.toDTO(lessonEntity);
    }

    public List<ResponseLessonByCourseId> findLessonsByCourseID(int courseid) {
        List<Lesson> lessonEntity = lessonRepository.findLessonsByID(courseid);
        List<ResponseLessonByCourseId> lessonModels = lessonEntity.stream()
                .map(lessonConverter::toResponse)
                .collect(Collectors.toList());

        return lessonModels;

    }
}
