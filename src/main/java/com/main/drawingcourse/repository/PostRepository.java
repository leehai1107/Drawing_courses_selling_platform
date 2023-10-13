package com.main.drawingcourse.repository;

import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
//    List<PostModel> findPostByPostcategoryId(int id);
    @Query(
            value = "SELECT * FROM POSTS p WHERE p.post_category_id = :id",
            nativeQuery = true)
    List<Post> findAllPostByPostCategoryID(@Param("id") int id);

}
