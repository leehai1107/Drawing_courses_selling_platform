package com.main.drawingcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.drawingcourse.entity.DrawingCategory;

@Repository

public interface DrawingCategoryRepository extends JpaRepository<DrawingCategory, Integer> {
	DrawingCategory findOneByDrawCategoryId(int cateID);

	DrawingCategory findByDrawCategoryName(String name);
}
