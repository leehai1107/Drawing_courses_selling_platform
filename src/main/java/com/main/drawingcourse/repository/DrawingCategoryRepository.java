package com.main.drawingcourse.repository;

import com.main.drawingcourse.entity.DrawingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrawingCategoryRepository extends JpaRepository<DrawingCategory, Integer> {
    DrawingCategory findOneByDrawCategoryId(int cateID);
}
