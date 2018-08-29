package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.entity.User;
import com.fitec.formation.wiki.model.ArticleModel;
import com.fitec.formation.wiki.model.CommentModel;
import com.fitec.formation.wiki.model.UserModel;

public class UserMapper {

    public static User mapToUser(UserModel um) {
        User u = new User();
        u.setUserLogger(UserLoggerMapper.mapToUserLogger(um.getUserLoggerModel()));
        u.setUserInfo(UserInfoMapper.mapToUserInfo(um.getUserInfoModel()));
        for (ArticleModel am : um.getArticlesModel()) {
            u.getArticles().add(ArticleMapper.mapToArticle(am));
        }
        for (CommentModel cm : um.getCommentsModel()) {
            u.getComments().add(CommentMapper.mapToComment(cm));
        }
        u.setStatus(StatusMapper.mapToStatus(um.getStatusModel()));
        return u;
    }

    public static UserModel mapToUserModel(User u) {
        UserModel um = new UserModel();
        um.setUserLoggerModel(UserLoggerMapper.mapToUserLoggerModel(u.getUserLogger()));
        um.setUserInfoModel(UserInfoMapper.mapToUserInfoModel(u.getUserInfo()));
        for (Article a : u.getArticles()) {
            um.getArticlesModel().add(ArticleMapper.mapToArticleModel(a));
        }
        for (Comment c : u.getComments()) {
            um.getCommentsModel().add(CommentMapper.mapToCommentModel(c));
        }
        um.setStatusModel(StatusMapper.mapToStatusModel(u.getStatus()));
        return um;
    }
}
