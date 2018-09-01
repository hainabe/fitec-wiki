package com.fitec.formation.wiki.entity;

import com.fitec.formation.wiki.model.StatusModel;
import com.fitec.formation.wiki.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_ARTICLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "YEAR_RECORD")
    private String year;

    //    @JoinTable(name = "ARTICLE_STATUS", joinColumns = {
    //            @JoinColumn(name = "ID_ARTICLE")}, inverseJoinColumns = {
    //            @JoinColumn(name = "ID_STATUS")})
    //-------------------------------------------------------------------------
    //    @ManyToOne(cascade = CascadeType.ALL)
    //    @JoinColumn(name = "ARTICLE_STATUS", referencedColumnName = "VALUE")
    //-------------------------------------------------------------------------
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusModel status;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Article(String title, String content, Date creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public Article(String title, String content, Date creationDate, StatusModel status) {
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

    public void setYear() {
        this.year = String.valueOf(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(this.creationDate)).getYear());
    }

    public String getYear() {
        return String.valueOf(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(this.creationDate)).getYear());
    }

    @Override
    public String toString() {
        return title + "[" + idArticle + "] " + content + " (" + creationDate + ")";
    }
}
