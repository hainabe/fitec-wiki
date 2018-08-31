package com.fitec.formation.wiki.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "T_USER")
@Getter
@Setter
@NoArgsConstructor
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Status status;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Article> articles;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;


    public User(UserLogger userLogger) {
        this.userLogger = userLogger;
    }

    public User(UserLogger userLogger, UserInfo userInfo) {
        this.userLogger = userLogger;
        this.userInfo = userInfo;
    }

    public User(UserLogger userLogger, UserInfo userInfo, Status status) {
        this.userLogger = userLogger;
        this.userInfo = userInfo;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User [" + idUser + "]\n" +
                userLogger + "\n" +
                userInfo;
    }
}
