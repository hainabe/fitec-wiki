package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitec.formation.wiki.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleModel {

    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = MessageUtil.DATE_PATTERN)
    private Date creationDate;
    private String year;

    private UserModel userModel;
    private List<CommentModel> commentsModel;
    private StatusModel statusModel;

    public ArticleModel(String title, String content, Date creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.year = getYear();
    }

    public ArticleModel(String title, String content, Date creationDate, StatusModel statusModel) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.year = getYear();
        this.statusModel = statusModel;
    }

    public void setYear() {
        this.year = String.valueOf(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(this.creationDate)).getYear());
    }

    public String getYear() {
        return String.valueOf(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(this.creationDate)).getYear());
    }

    @Override
    public String toString() {
        return title + "[] " + content + " (" + getYear() + ")";
    }
}
