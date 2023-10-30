package com.main.drawingcourse.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
