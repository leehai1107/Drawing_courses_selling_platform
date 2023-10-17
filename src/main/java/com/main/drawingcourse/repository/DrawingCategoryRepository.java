package com.main.drawingcourse.repository;

import com.main.drawingcourse.entity.DrawingCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface DrawingCategoryRepository extends JpaRepository<DrawingCategory, Integer> {
    DrawingCategory findOneByDrawCategoryId(int cateID);
    DrawingCategory findByDrawCategoryName(String name);
}
