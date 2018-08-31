package com.fitec.formation.wiki.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_ARTICLE")
@Getter
@Setter
@NoArgsConstructor
public class Article implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ARTICLE")
    private Long idArticle;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @ManyToOne
    private Status status;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Article(String title, String content, Date creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public Article(String title, String content, Date creationDate, Status status) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return title + "[" + idArticle + "] " + content + " (" + creationDate + ")";
    }
}
