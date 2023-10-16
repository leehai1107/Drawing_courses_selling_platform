package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.LessonConverter;
import com.main.drawingcourse.dto.LessonModel;
import com.main.drawingcourse.entity.Lesson;
import com.main.drawingcourse.repository.LessonRepository;
import com.main.drawingcourse.repository.UnitRepository;
import com.main.drawingcourse.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
