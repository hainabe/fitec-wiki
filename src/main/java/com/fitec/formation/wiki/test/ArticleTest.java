package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleTest {

    public static List<Article> initArticleSuite() {
        final List<Article> articles = new ArrayList<>();
        articles.add(new Article());
        return articles;
    }
}
