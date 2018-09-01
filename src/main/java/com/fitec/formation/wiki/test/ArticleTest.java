package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.model.StatusModel;
import com.fitec.formation.wiki.service.ArticleService;
import com.fitec.formation.wiki.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleTest {

    @Autowired
    DateUtil dateUtil;
    @Autowired
    UserTest userTest;


    public List<Article> initArticleSuite() {
        List<Article> articles = new ArrayList<>();

        final Article a01 = new Article();
        a01.setTitle("title01");
        a01.setContent("content01");
        a01.setCreationDate(dateUtil.formatDate("01-01-2011"));
        a01.setStatus(StatusModel.STATUS_ARTICLE_APPROVED);
        a01.setUser(userTest.initUserSuite().get(0));
        articles.add(a01);

        final Article a02 = new Article();
        a02.setTitle("title02");
        a02.setContent("content02");
        a02.setCreationDate(dateUtil.formatDate("02-02-2012"));
        a02.setStatus(StatusModel.STATUS_ARTICLE_APPROVED);
        a02.setUser(userTest.initUserSuite().get(1));
        articles.add(a02);

        final Article a03 = new Article();
        a03.setTitle("title03");
        a03.setContent("content03");
        a03.setCreationDate(dateUtil.formatDate("03-03-2013"));
        a01.setStatus(StatusModel.STATUS_ARTICLE_APPROVED);
        a01.setUser(userTest.initUserSuite().get(2));
        articles.add(a03);

        System.out.println("initArticleSuite() = " + !articles.isEmpty());
        return articles;
    }
}
