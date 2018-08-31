package com.fitec.formation.wiki.service;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {

    boolean addArticle(Article a);

//    Article getArticle(Long id);
//
//    boolean updateArticle(Article a);
//
//    boolean deleteArticle(Long id);
//
//    List<Article> getArticles();
//
//    List<Article> getArticlesByStatus(Status status);
//
//    List<Article> getArticlesByUser(String username);
//
//    List<Article> getArticlesByYear(String strYear);

}
