package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitec.formation.wiki.util.JsonUtil;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleModel {

    private Long idArticle;
    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonUtil.DATE_PATTERN)
    private Date creationDate;

    private UserModel userModel;
    private List<CommentModel> commentsModel;

    public ArticleModel() {
    }

    public ArticleModel(String title, String content, Date creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public ArticleModel(Long idArticle, String title, String content, Date creationDate) {
        this.idArticle = idArticle;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public List<CommentModel> getCommentsModel() {
        return commentsModel;
    }

    public void setCommentsModel(List<CommentModel> commentsModel) {
        this.commentsModel = commentsModel;
    }

    @Override
    public String toString() {
        return title + "[" + idArticle + "] " + content + " (" + creationDate + ")";
    }
}
