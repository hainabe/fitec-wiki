package com.fitec.formation.wiki.controller;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.mapper.ArticleMapper;
import com.fitec.formation.wiki.mapper.StatusMapper;
import com.fitec.formation.wiki.model.ArticleModel;
import com.fitec.formation.wiki.model.MessageModel;
import com.fitec.formation.wiki.model.StatusModel;
import com.fitec.formation.wiki.service.ArticleService;
import com.fitec.formation.wiki.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class ArticleController {

    @Autowired
    ArticleService articleService;

//    @RequestMapping(path = "/article/{id}", method = RequestMethod.GET) // @GetMapping
//    public ResponseEntity<Object> getArticle(@PathVariable("id") Long id) {
//        Article a = articleService.getArticle(id);
//        if (a != null) {
//            ArticleModel am = ArticleMapper.mapToArticleModel(a);
//            return new ResponseEntity<>(am, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
//    }

    @RequestMapping(path = "/article", method = RequestMethod.POST) // @PostMapping
    public ResponseEntity<Object> addArticle(@RequestBody ArticleModel am) {
        Article a = ArticleMapper.mapToArticle(am);
        if (articleService.addArticle(a)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_ADD), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_DB), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(path = "/article/{id}", method = RequestMethod.PUT) // @PutMapping
    public ResponseEntity<Object> updateArticle(@PathVariable("id") Long id,
                                                @RequestBody ArticleModel am) {
        Article a = ArticleMapper.mapToArticle(am);
        a.setIdArticle(id);
        if (articleService.updateArticle(a)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_UPDATE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/article/{id}", method = RequestMethod.DELETE) // @DeleteMapping
    public ResponseEntity<Object> deleteArticle(@PathVariable("id") Long id) {
        if (articleService.deleteArticle(id)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_DELETE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/articles", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getArticles() {
        List<Article> articles = articleService.getArticles();
        List<ArticleModel> articlesModel = new ArrayList<>();
        for (Article a : articles) {
            articlesModel.add(ArticleMapper.mapToArticleModel(a));
        }
        return new ResponseEntity<>(articlesModel, HttpStatus.OK);
    }

    @RequestMapping(path = "/articles/{status}", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getArticlesByStatus(@PathVariable("status") String status) {
        StatusModel sm = StatusModel.getStatus(StatusModel.valueOf(status).getId());
        List<Article> articles = articleService.getArticlesByStatus(sm);
        List<ArticleModel> articlesModel = new ArrayList<>();
        for (Article a : articles) {
            articlesModel.add(ArticleMapper.mapToArticleModel(a));
        }
        return new ResponseEntity<>(articlesModel, HttpStatus.OK);
    }

    @RequestMapping(path = "/articles/{username}", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getArticlesByUser(@PathVariable("username") String username) {
        List<Article> articles = articleService.getArticlesByUser(username);
        List<ArticleModel> articlesModel = new ArrayList<>();
        for (Article a : articles) {
            articlesModel.add(ArticleMapper.mapToArticleModel(a));
        }
        return new ResponseEntity<>(articlesModel, HttpStatus.OK);
    }

    @RequestMapping(path = "/articles/{year}", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getArticlesByYear(@PathVariable("year") String strYear) {
        List<Article> articles = articleService.getArticlesByYear(strYear);
        List<ArticleModel> articlesModel = new ArrayList<>();
        for (Article a : articles) {
            articlesModel.add(ArticleMapper.mapToArticleModel(a));
        }
        return new ResponseEntity<>(articlesModel, HttpStatus.OK);
    }
}
