package com.example.postbackend.service.entity;

import org.apache.lucene.analysis.core.KeywordTokenizerFactory;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.standard.StandardFilterFactory;
import org.hibernate.search.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Indexed
@Entity
@Table(name = "POST")
@AnalyzerDef(name = "postAnalyzer",
        tokenizer = @TokenizerDef(factory = KeywordTokenizerFactory.class ),
        filters = {
                @TokenFilterDef(factory = StandardFilterFactory.class),
                @TokenFilterDef(factory = LowerCaseFilterFactory.class),
        }
)
public class PostEntity {
    @Id
    @Column(name = "POST_ID", nullable = false)
    private String id;

    @Field(analyzer = @Analyzer(definition = "postAnalyzer"))
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "IMAGE")
    private String image;

    @Field(analyzer = @Analyzer(definition = "postAnalyzer"))
    @Column(name = "CONTENT")
    private String content;

    @Field(analyzer = @Analyzer(definition = "postAnalyzer"))
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
