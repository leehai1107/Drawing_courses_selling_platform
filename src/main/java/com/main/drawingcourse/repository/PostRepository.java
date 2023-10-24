package com.main.drawingcourse.repository;


import com.main.drawingcourse.entity.Course;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Integer> {
//    List<PostModel> findPostByPostcategoryId(int id);
    @Query(
            value = "SELECT * FROM POSTS p WHERE p.post_category_id = :id",
            nativeQuery = true)
    List<Post> findAllPostByPostCategoryID(@Param("id") int id);


    @Query(
            value = "SELECT * FROM POSTS p WHERE p.title = :title ",
            nativeQuery = true)
    Post findPostByTitle(@Param("title") String title);

    List<Post> findPostByPostId(int id);

    @Modifying
    @Query(
            value = "DELETE p FROM POSTS p WHERE p.post_id = :id AND p.user_id IN ( SELECT user_id FROM users u WHERE u.role_id IN ( SELECT role_id FROM roles r WHERE r.role_id = 1 or r.role_id = 2 or r.role_id = 4))",
            nativeQuery = true)
    void deleteByPostId(@Param("id") int id);

    @Query(
            value = "SELECT * FROM POSTS p WHERE p.status = 1",nativeQuery = true
    )
    List<Post> viewpostbystatustrue(@Param("status") boolean status);

//    @Query("SELECT\n" +
//            "    p.post_id," +
//            "    p.Title," +
//            "    u.user_id," +
//            "    u.fullname," +
//            "    pc.post_category_id," +
//            "    pc.post_category_name AS PostCategoryName" +
//            "FROM POSTS p" +
//            "    INNER JOIN Users u ON u.user_id = p.user_id" +
//            "    INNER JOIN post_categories pc ON pc.post_category_id = p.post_category_id")
//    List<Post> findAllPostsWithUserInfoAndCategory();


//    @Query("SELECT p.postId, p.title, u.userId, u.fullname, pc.postCategoryId, pc.postCategoryName AS postCategoryName " +
//            "FROM Post p " +
//            "JOIN p.user u " +
//            "JOIN p.postCategory pc")
//    List<Post> findAllPostsWithUserInfoAndCategory();


//    @Query("SELECT p.postId, p.title, u.userId, u.fullname, pc.postCategoryId, pc.postCategoryName AS postCategoryName " +
//            "FROM Post p " +
//            "JOIN p.user u " +
//            "JOIN p.postCategory pc")
//    List<Post> findAll();


}
