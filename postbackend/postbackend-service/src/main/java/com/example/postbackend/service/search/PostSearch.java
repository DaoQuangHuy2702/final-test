package com.example.postbackend.service.search;

import com.example.postbackend.service.entity.PostEntity;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class PostSearch {
    private static final String POST_TITLE = "title";
    private static final String POST_CATEGORY = "category";
    private static final String POST_CONTENT = "content";

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public PostSearch(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<PostEntity> searchPost(String searchTerm) {
        entityManager = entityManagerFactory.createEntityManager();
        FullTextEntityManager fullTextEntityManager = initializedFullTextEntityManager();

        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
                .forEntity(PostEntity.class).get();

        BooleanJunction<BooleanJunction> booleanJunction =
                HibernateSearchUtil.buildBooleanJunctionSearch(
                        qb,
                        searchTerm,
                        POST_TITLE,
                        POST_CATEGORY,
                        POST_CONTENT);

        FullTextQuery query = fullTextEntityManager.createFullTextQuery(booleanJunction.createQuery(), PostEntity.class);

        List<PostEntity> list = query.getResultList();
        commitTransaction();

        return list;
    }

    private FullTextEntityManager initializedFullTextEntityManager() {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        entityManager.getTransaction().begin();

        return fullTextEntityManager;
    }

    private void commitTransaction() {
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
