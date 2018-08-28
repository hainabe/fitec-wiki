package com.fitec.formation.wiki.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private Long idUser;
    @Embedded
    @Column(name = "USER_LOGGER")
    private UserLogger userLogger;
    @Embedded
    @Column(name = "USER_INFORMATION")
    private UserInfo userInfo;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Article> articles;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    public User() {
    }

    public User(UserLogger userLogger) {
        this.userLogger = userLogger;
    }

    public User(UserLogger userLogger, UserInfo userInfo) {
        this.userLogger = userLogger;
        this.userInfo = userInfo;
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public UserLogger getUserLogger() {
        return userLogger;
    }

    public void setUserLogger(UserLogger userLogger) {
        this.userLogger = userLogger;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User [" + idUser + "]\n" +
                userLogger + "\n" +
                userInfo;
    }
}
