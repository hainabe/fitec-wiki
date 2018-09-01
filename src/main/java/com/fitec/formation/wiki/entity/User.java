package com.fitec.formation.wiki.entity;

import com.fitec.formation.wiki.model.StatusModel;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
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

    //    @JoinTable(name = "USER_STATUS", joinColumns = {
    //            @JoinColumn(name = "ID_USER")}, inverseJoinColumns = {
    //            @JoinColumn(name = "ID_STATUS")})
    //-------------------------------------------------------------------------
    //    @ManyToOne(cascade = CascadeType.ALL)
    //    @JoinColumn(name = "USER_STATUS", referencedColumnName = "VALUE")
    //-------------------------------------------------------------------------
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusModel status;
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

    public User(UserLogger userLogger, UserInfo userInfo, StatusModel status) {
        this.userLogger = userLogger;
        this.userInfo = userInfo;
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

    @Override
    public String toString() {
        return "User [" + idUser + "]\n" +
                userLogger + "\n" +
                userInfo;
    }
}
