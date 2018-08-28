package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.model.CommentModel;

public class CommentMapper {

    public static Comment mapToComment(CommentModel cm) {
        Comment c = new Comment();
        c.setTitle(cm.getTitle());
        c.setContent(cm.getContent());
        c.setCreationDate(cm.getCreationDate());
        c.setArticle(ArticleMapper.mapToArticle(cm.getArticleModel()));
        c.setUser(UserMapper.mapToUser(cm.getUserModel()));
        c.setParentComment(CommentMapper.mapToComment(cm.getParentCommentModel()));
        for (CommentModel chm : cm.getChildCommentsModel()) {
            c.getChildComments().add(CommentMapper.mapToComment(chm));
        }
        return c;
    }

    public static CommentModel mapToCommentModel(Comment c) {
        CommentModel cm = new CommentModel();
        cm.setTitle(c.getTitle());
        cm.setContent(c.getContent());
        cm.setCreationDate(c.getCreationDate());
        cm.setArticleModel(ArticleMapper.mapToArticleModel(c.getArticle()));
        cm.setUserModel(UserMapper.mapToUserModel(c.getUser()));
        cm.setParentCommentModel(CommentMapper.mapToCommentModel(c.getParentComment()));
        for (Comment ch : c.getChildComments()) {
            cm.getChildCommentsModel().add(CommentMapper.mapToCommentModel(ch));
        }
        return cm;
    }
}
