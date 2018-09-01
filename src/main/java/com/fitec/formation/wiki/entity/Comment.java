package com.fitec.formation.wiki.entity;

import com.fitec.formation.wiki.model.StatusModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_COMMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    //    @JoinTable(name = "COMMENT_STATUS", joinColumns = {
    //            @JoinColumn(name = "ID_COMMENT")}, inverseJoinColumns = {
    //            @JoinColumn(name = "ID_STATUS")})
    //-------------------------------------------------------------------------
    //    @ManyToOne(cascade = CascadeType.ALL)
    //    @JoinColumn(name = "COMMENT_STATUS", referencedColumnName = "VALUE")
    //-------------------------------------------------------------------------
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusModel status;
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

    public Comment(String title, String content, Date creationDate, StatusModel status) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.status = status;
    }

    public StatusModel getStatus() {
        return StatusModel.getStatus(this.status.getId());
    }

    public void setStatus(StatusModel sm) {
        if (sm == null) {
            this.status = null;
        } else {
            this.status = sm;
        }
    }

    public boolean isParent() {
        return Objects.nonNull(parentComment);
    }

    @Override
    public String toString() {
        return title + "[" + isParent() + ", " + idComment + "] " + content + " (" + creationDate + ")";
    }
}
