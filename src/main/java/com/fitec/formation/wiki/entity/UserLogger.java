package com.fitec.formation.wiki.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Table(name = "T_USER_LOGGER")
@Getter
@Setter
@NoArgsConstructor
public class UserLogger implements Serializable {

    private static final Long serialVersionUID = 1L;

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER_LOGGER")
    private Long idUserLogger;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @ManyToOne
    private Profile profile;

    public UserLogger(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserLogger(String email, String username, String password, Date creationDate, Profile profile) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
        this.profile = profile;
    }

    @Override
    public String toString() {
        return username + " " + password + " [" + idUserLogger + "] " + profile + " (" + creationDate + ")";
    }
}
