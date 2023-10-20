package com.main.drawingcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLessonByCourseId {

    private int lessonId;
    private String title;
    private String content;
    private String videoUrl;
    private LocalTime videoduration;
    private boolean lessonstatus;
    private CourseModel courseInfo;
}
