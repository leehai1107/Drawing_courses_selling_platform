package com.main.drawingcourse.converter;

import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    public Post toEntity(PostModel PostDTO) {
        Post entity = new Post();
        entity.setPostId(PostDTO.getPostid());
        entity.setTitle(PostDTO.getTitle());
        entity.setContent(PostDTO.getContent());
        entity.setPostDate(PostDTO.getPostDate());

        return entity;
    }

    public PostModel toDTO(Post PostEntity) {
        PostModel DTO = new PostModel();
        DTO.setPostid(PostEntity.getPostId());
        DTO.setTitle(PostEntity.getTitle());
        DTO.setContent(PostEntity.getContent());
        DTO.setPostDate(PostEntity.getPostDate());

        return DTO;
    }
}
