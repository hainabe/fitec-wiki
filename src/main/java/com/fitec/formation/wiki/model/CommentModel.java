package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitec.formation.wiki.util.JsonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
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
    private StatusModel statusModel;

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

    public CommentModel(String title, String content, Date creationDate, StatusModel statusModel) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.statusModel = statusModel;
    }

    public CommentModel(Long idComment, String title, String content, Date creationDate, StatusModel statusModel) {
        this.idComment = idComment;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.statusModel = statusModel;
    }

    @Override
    public String toString() {
        return title + "[" + parentCommentModel.getIdComment() + ", " + idComment + "] " + content + " (" + creationDate + ")";
    }
}
