package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitec.formation.wiki.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentModel {

    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = MessageUtil.DATE_PATTERN)
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

    public CommentModel(String title, String content, Date creationDate, StatusModel statusModel) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.statusModel = statusModel;
    }

    public boolean isParent() {
        return Objects.nonNull(parentCommentModel);
    }

    @Override
    public String toString() {
        return title + "[" + isParent() + "] " + content + " (" + creationDate + ")";
    }
}
