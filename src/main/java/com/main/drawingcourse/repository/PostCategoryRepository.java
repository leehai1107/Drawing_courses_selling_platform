package com.main.drawingcourse.repository;

import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Integer> {
    PostCategory findOneByPostCategoryId(int id);


}
