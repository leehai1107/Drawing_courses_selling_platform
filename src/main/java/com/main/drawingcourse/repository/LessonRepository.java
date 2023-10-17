package com.main.drawingcourse.repository;

import com.main.drawingcourse.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {


}
