package com.main.drawingcourse.repository;

import com.main.drawingcourse.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
