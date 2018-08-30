package com.fitec.formation.wiki.service;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Status;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {


    @Override
    public boolean addArticle(Article a) {
        return false;
    }

    @Override
    public Article getArticle(Long id) {
        return null;
    }

    @Override
    public boolean updateArticle(Article a) {
        return false;
    }

    @Override
    public boolean deleteArticle(Long id) {
        return false;
    }

    @Override
    public List<Article> getArticles() {
        return null;
    }

    @Override
    public List<Article> getArticlesByStatus(Status status) {
        return null;
    }

    @Override
    public List<Article> getArticlesByUser(String username) {
        return null;
    }

    @Override
    public List<Article> getArticlesByYear(String strYear) {
        return null;
    }
}
