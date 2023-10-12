package com.main.drawingcourse.service.impl;

import com.main.drawingcourse.converter.PostConverter;
import com.main.drawingcourse.dto.LevelModel;
import com.main.drawingcourse.dto.PostModel;
import com.main.drawingcourse.entity.Post;
import com.main.drawingcourse.repository.PostRepository;
import com.main.drawingcourse.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class PostImpl implements IPostService {
    @Autowired
     PostRepository postRepository;
    @Autowired
    PostConverter postConverter;

    public List<PostModel> findAll() {
        List<PostModel> Posts = postRepository.findAll().stream()
                .map(postConverter::toDTO)
                .collect(Collectors.toList());

        return Posts;
    }
}
