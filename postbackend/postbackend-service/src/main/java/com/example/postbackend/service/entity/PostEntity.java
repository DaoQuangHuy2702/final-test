package com.example.postbackend.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "POST")
public class PostEntity {
    @Id
    @Column(name = "POST_ID", nullable = false)
    private String id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "CREATE_AT")
    private Timestamp createAt;

    @Column(name = "UPDATE_AT")
    private Timestamp updateAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
}
