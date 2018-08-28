package com.fitec.formation.wiki.entity;

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
public class UserLogger implements Serializable {

    private static final Long serialVersionUID = 1L;

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER_LOGGER")
    private Long idUserLogger;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @ManyToOne
    private Profile profile;

    public UserLogger() {
    }

    public UserLogger(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserLogger(String username, String password, Date creationDate, Profile profile) {
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
        this.profile = profile;
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdUserLogger() {
        return idUserLogger;
    }

    public void setIdUserLogger(Long idUserLogger) {
        this.idUserLogger = idUserLogger;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return username + " " + password + " [" + idUserLogger + "] " + profile + " (" + creationDate + ")";
    }
}
