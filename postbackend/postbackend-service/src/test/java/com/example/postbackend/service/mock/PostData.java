package com.example.postbackend.service.mock;

import com.example.postbackend.api.model.Post;
import com.example.postbackend.api.model.PostRequest;
import com.example.postbackend.api.model.Posts;
import com.example.postbackend.service.entity.PostEntity;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class PostData {
    public static final String POST_ID = "2347edfd-c11c-4f59-96ee-600492f933f3";
    public static final String TITLE = "ReactJS Become a professional in web app development";
    public static final String IMAGE = "https://images-na.ssl-images-amazon.com/images/I/41ith8XYqwS._SX331_BO1,204,203,200_.jpg";
    public static final String CONTENT = "industrys standard dummy texter since the 1500s, when an unknown printer took a galley of type and scrambled";
    public static final String CATEGORY = "ART";
    public static final String CREATE_AT = "2022-07-01 08:57:11";
    public static final String UPDATE_AT = "2022-07-01 08:57:11";

    public static Post mockPost() {
        Post post = new Post();

        post.setId(POST_ID);
        post.setTitle(TITLE);
        post.setImage(IMAGE);
        post.setContent(CONTENT);
        post.setCategory(Post.CategoryEnum.fromValue(CATEGORY));
        post.setCreateAt(CREATE_AT);
        post.setUpdateAt(UPDATE_AT);

        return post;
    }

    public static Posts mockPosts() {
        Posts posts = new Posts();
        posts.add(mockPost());

        return posts;
    }

    public static PostRequest mockPostRequest() {
        PostRequest postRequest = new PostRequest();

        postRequest.setTitle(TITLE);
        postRequest.setImage(IMAGE);
        postRequest.setContent(CONTENT);
        postRequest.setCategory(PostRequest.CategoryEnum.fromValue(CATEGORY));

        return postRequest;
    }

    public static PostEntity mockPostEntity() {
        PostEntity postEntity = new PostEntity();

        postEntity.setId(POST_ID);
        postEntity.setTitle(TITLE);
        postEntity.setImage(IMAGE);
        postEntity.setContent(CONTENT);
        postEntity.setCategory(CATEGORY);
        postEntity.setCreateAt(new Timestamp(Instant.now().toEpochMilli()));
        postEntity.setUpdateAt(new Timestamp(Instant.now().toEpochMilli()));

        return postEntity;
    }

    public static List<PostEntity> mockPostEntities() {
        return Arrays.asList(mockPostEntity());
    }
}
