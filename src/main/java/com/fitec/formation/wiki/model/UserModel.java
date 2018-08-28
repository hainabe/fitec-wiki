package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel {

    private Long idUserModel;
    private UserLoggerModel userLoggerModel;
    private UserInfoModel userInfoModel;

    private List<ArticleModel> articlesModel;
    private List<CommentModel> commentsModel;

    public UserModel() {
    }

    public UserModel(UserLoggerModel userLoggerModel) {
        this.userLoggerModel = userLoggerModel;
    }

    public UserModel(UserLoggerModel userLoggerModel, UserInfoModel userInfoModel) {
        this.userLoggerModel = userLoggerModel;
        this.userInfoModel = userInfoModel;
    }

    public UserModel(Long idUserModel, UserLoggerModel userLoggerModel, UserInfoModel userInfoModel) {
        this.idUserModel = idUserModel;
        this.userLoggerModel = userLoggerModel;
        this.userInfoModel = userInfoModel;
    }

    public Long getIdUserModel() {
        return idUserModel;
    }

    public void setIdUserModel(Long idUserModel) {
        this.idUserModel = idUserModel;
    }

    public UserLoggerModel getUserLoggerModel() {
        return userLoggerModel;
    }

    public void setUserLoggerModel(UserLoggerModel userLoggerModel) {
        this.userLoggerModel = userLoggerModel;
    }

    public UserInfoModel getUserInfoModel() {
        return userInfoModel;
    }

    public void setUserInfoModel(UserInfoModel userInfoModel) {
        this.userInfoModel = userInfoModel;
    }

    public List<ArticleModel> getArticlesModel() {
        return articlesModel;
    }

    public void setArticlesModel(List<ArticleModel> articlesModel) {
        this.articlesModel = articlesModel;
    }

    public List<CommentModel> getCommentsModel() {
        return commentsModel;
    }

    public void setCommentsModel(List<CommentModel> commentsModel) {
        this.commentsModel = commentsModel;
    }

    @Override
    public String toString() {
        return "User [" + idUserModel + "]\n" +
                userLoggerModel + "\n" +
                userInfoModel;
    }
}
