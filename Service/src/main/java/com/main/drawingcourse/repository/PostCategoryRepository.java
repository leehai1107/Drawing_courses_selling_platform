package com.main.drawingcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.drawingcourse.entity.PostCategory;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, Integer> {
	PostCategory findOneByPostCategoryId(int id);

	PostCategory findOneByPostCategoryName(String name);

	@Override
	List<PostCategory> findAll();
}
