package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitec.formation.wiki.util.JsonUtil;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentModel {

    private Long idComment;
    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonUtil.DATE_PATTERN)
    private Date creationDate;

    private ArticleModel articleModel;
    private UserModel userModel;
    private CommentModel parentCommentModel;
    private List<CommentModel> childCommentsModel;

    public CommentModel() {
    }

    public CommentModel(String title, String content, Date creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public CommentModel(Long idComment, String title, String content, Date creationDate) {
        this.idComment = idComment;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
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

    public ArticleModel getArticleModel() {
        return articleModel;
    }

    public void setArticleModel(ArticleModel articleModel) {
        this.articleModel = articleModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public CommentModel getParentCommentModel() {
        return parentCommentModel;
    }

    public void setParentCommentModel(CommentModel parentCommentModel) {
        this.parentCommentModel = parentCommentModel;
    }

    public List<CommentModel> getChildCommentsModel() {
        return childCommentsModel;
    }

    public void setChildCommentsModel(List<CommentModel> childCommentsModel) {
        this.childCommentsModel = childCommentsModel;
    }

    @Override
    public String toString() {
        return title + "[" + parentCommentModel.getIdComment() + ", " + idComment + "] " + content + " (" + creationDate + ")";
    }
}
