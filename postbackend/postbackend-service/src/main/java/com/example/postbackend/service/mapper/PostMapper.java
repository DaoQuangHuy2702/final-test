package com.example.postbackend.service.mapper;

import com.example.postbackend.api.model.Post;
import com.example.postbackend.api.model.PostRequest;
import com.example.postbackend.api.model.Posts;
import com.example.postbackend.service.entity.PostEntity;
import com.example.postbackend.service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostMapper {
    private final PostRepository repo;

    @Autowired
    public PostMapper(PostRepository repo) {
        this.repo = repo;
    }

    public PostEntity mapPostEntityFromPostRequest(PostRequest from) {
        PostEntity to = new PostEntity();

        to.setId(UUID.randomUUID().toString());
        to.setTitle(from.getTitle());
        to.setImage(from.getImage());
        to.setCategory(from.getCategory().name());
        to.setContent(from.getContent());
        to.setCreateAt(new Timestamp(Instant.now().toEpochMilli()));
        to.setUpdateAt(new Timestamp(Instant.now().toEpochMilli()));

        return to;
    }

    public PostEntity mapPostEntityFromPostRequest(String id, PostRequest from) {
        PostEntity to = repo.getOne(id);

        to.setTitle(from.getTitle());
        to.setImage(from.getImage());
        to.setCategory(from.getCategory().name());
        to.setContent(from.getContent());
        to.setUpdateAt(new Timestamp(Instant.now().toEpochMilli()));

        return to;
    }

    public Post mapPostFromPostEntity(PostEntity from) {
        Post to = new Post();

        to.setId(from.getId());
        to.setTitle(from.getTitle());
        to.setImage(from.getImage());
        to.setContent(from.getContent());
        to.setCategory(Post.CategoryEnum.fromValue(from.getCategory()));
        to.setCreateAt(from.getCreateAt().toLocalDateTime().toString());
        to.setUpdateAt(from.getUpdateAt().toLocalDateTime().toString());

        return to;
    }

    public Posts mapPostsFromPostEntities(List<PostEntity> from) {
        return from.stream().map(this::mapPostFromPostEntity).collect(Collectors.toCollection(Posts::new));
    }
}
