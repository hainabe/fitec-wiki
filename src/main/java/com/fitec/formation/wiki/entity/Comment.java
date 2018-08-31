package com.fitec.formation.wiki.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_COMMENT")
@Getter
@Setter
@NoArgsConstructor
public class Comment implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMMENT")
    private Long idComment;
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
    private Article article;
    @ManyToOne
    private User user;
    @ManyToOne
    @JoinColumn(name = "PARENT_COMMENT", referencedColumnName = "ID_COMMENT")
    private Comment parentComment;
    @OneToMany(mappedBy = "parentComment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> childComments;


    public Comment(String title, String content, Date creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public Comment(String title, String content, Date creationDate, Status status) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return title + "[" + parentComment.getIdComment() + ", " + idComment + "] " + content + " (" + creationDate + ")";
    }
}
