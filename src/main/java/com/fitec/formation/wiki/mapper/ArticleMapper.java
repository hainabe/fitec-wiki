package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.model.ArticleModel;
import com.fitec.formation.wiki.model.CommentModel;

public class ArticleMapper {

    public static Article mapToArticle(ArticleModel am) {
        Article a = new Article();
        a.setTitle(am.getTitle());
        a.setContent(am.getContent());
        a.setCreationDate(am.getCreationDate());
        a.setUser(UserMapper.mapToUser(am.getUserModel()));
        for (CommentModel cm : am.getCommentsModel()) {
            a.getComments().add(CommentMapper.mapToComment(cm));
        }
        a.setStatus(am.getStatusModel());
        return a;
    }

    public static ArticleModel mapToArticleModel(Article a) {
        ArticleModel am = new ArticleModel();
        am.setTitle(a.getTitle());
        am.setContent(a.getContent());
        am.setCreationDate(a.getCreationDate());
        am.setUserModel(UserMapper.mapToUserModel(a.getUser()));
        for (Comment c : a.getComments()) {
            am.getCommentsModel().add(CommentMapper.mapToCommentModel(c));
        }
        am.setStatusModel(a.getStatus());
        return am;
    }
}
