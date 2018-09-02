package com.fitec.formation.wiki.service;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.model.StatusModel;
import com.fitec.formation.wiki.repository.ArticleRepository;
import com.fitec.formation.wiki.util.DateUtil;
import com.fitec.formation.wiki.util.MessageUtil;
import com.fitec.formation.wiki.util.PropertyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    DateUtil dateUtil;
    @Autowired
    PropertyUtil propertyUtil;

    @Override
    public boolean addArticle(Article a) {
        boolean result = false;
        if (Objects.nonNull(a)) {
            result = Objects.nonNull(articleRepository.save(a));
            System.out.println(MessageUtil.MSG_SUCCESS_ADD);
        } else {
            System.out.println(MessageUtil.MSG_ERROR_NULL);
        }
        return result;
    }

    @Override
    public Article getArticle(Long id) {
        Article article = articleRepository.getOne(id);
        return article;
    }

    @Override
    public boolean updateArticle(Article oldA) {
        boolean result = false;
        Article targetArticle = articleRepository.getOne(oldA.getIdArticle());
        if (Objects.nonNull(oldA) && articleRepository.existsById(oldA.getIdArticle())) {
            BeanUtils.copyProperties(oldA, targetArticle, propertyUtil.getNullPropertyNames(oldA));
            result = Objects.nonNull(articleRepository.save(targetArticle));
            System.out.println(MessageUtil.MSG_SUCCESS_UPDATE);
        } else {
            System.out.println(MessageUtil.MSG_ERROR_NULL_NOT_FOUND);
        }
        return result;
    }

    @Override
    public boolean deleteArticle(Long id) {
        boolean result = false;
        if (articleRepository.existsById(id)) {
            articleRepository.delete(getArticle(id));
            result = true;
            System.out.println(MessageUtil.MSG_SUCCESS_DELETE);
        } else {
            System.out.println(MessageUtil.MSG_ERROR_NOT_FOUND);
        }
        return result;
    }

    @Override
    public List<Article> getArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles;
    }

    @Override
    public List<Article> getArticlesByStatus(StatusModel status) {
        List<Article> articles = articleRepository.getArticlesByStatus(status);
        return articles;
    }

    @Override
    public List<Article> getArticlesByUser(String username) {
        List<Article> articles = articleRepository.getArticlesByUser(username);

        return articles;
    }

    @Override
    public List<Article> getArticlesByYear(String strYear) {
        List<Article> articles = articleRepository.getArticlesByYear(strYear);
        return articles;
    }
}
