package com.example.postbackend.service.service;

import com.example.postbackend.api.model.Post;
import com.example.postbackend.api.model.PostRequest;
import com.example.postbackend.api.model.Posts;
import com.example.postbackend.service.entity.PostEntity;
import com.example.postbackend.service.mapper.PostMapper;
import com.example.postbackend.service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServices {
    private final PostRepository repo;
    private final PostMapper mapper;

    @Autowired
    public PostServices(PostRepository repo, PostMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Posts getAllPosts(Integer page, Integer limit) {
        if(page != null && limit != null) {
            return mapper.mapPostsFromPostEntities(slice(repo.findAll(), page, limit));
        }
        return mapper.mapPostsFromPostEntities(repo.findAll());
    }

    public Post getPostById(String id) {
        PostEntity postEntity = repo.getOne(id);
        Post post = mapper.mapPostFromPostEntity(postEntity);

        return post;
    }

    public Post addPost(PostRequest postReq) {
        PostEntity postEntity = mapper.mapPostEntityFromPostRequest(postReq);
        PostEntity saved = repo.save(postEntity);

        return mapper.mapPostFromPostEntity(saved);
    }

    public Post updatePostById(String id, PostRequest postReq) {
        PostEntity postEntity = mapper.mapPostEntityFromPostRequest(id, postReq);
        PostEntity saved = repo.save(postEntity);

        return mapper.mapPostFromPostEntity(saved);
    }

    public void removePostById(String id) {
        PostEntity postEntity = repo.getOne(id);
        repo.delete(postEntity);
    }

    private List<PostEntity> slice(List<PostEntity> list, int page, int limit) {
        List<PostEntity> result = new ArrayList<>();
        int start = page;
        int end;
        if(start >= 0 && start < list.size()) {
            if(start + limit < list.size()) {
                end = start + limit;
            }
            else {
                end = list.size();
            }
            for(int i = start; i < end; i++) {
                result.add(list.get(i));
            }
        }
        return result;
    }
}
