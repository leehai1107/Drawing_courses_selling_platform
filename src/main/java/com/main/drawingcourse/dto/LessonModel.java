package com.main.drawingcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class LessonModel {

    private int lessonId;
    private String title;
    private String content;
    private String videoUrl;
    private LocalTime videoduration;
    private boolean lessonstatus;
        private int courseId;
}
