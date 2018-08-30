package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitec.formation.wiki.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleModel {

    private Long idArticleModel;
    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonUtil.DATE_PATTERN)
    private Date creationDate;

    private UserModel userModel;
    private List<CommentModel> commentsModel;
    private StatusModel statusModel;

    public ArticleModel(String title, String content, Date creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public ArticleModel(Long idArticleModel, String title, String content, Date creationDate) {
        this.idArticleModel = idArticleModel;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public ArticleModel(String title, String content, Date creationDate, StatusModel statusModel) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.statusModel = statusModel;
    }

    public ArticleModel(Long idArticleModel, String title, String content, Date creationDate, StatusModel statusModel) {
        this.idArticleModel = idArticleModel;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.statusModel = statusModel;
    }

    @Override
    public String toString() {
        return title + "[" + idArticleModel + "] " + content + " (" + creationDate + ")";
    }
}
