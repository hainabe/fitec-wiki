package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitec.formation.wiki.util.JsonUtil;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLoggerModel {

    private Long idUserLoggerModel;
    private String username;
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonUtil.DATE_PATTERN)
    private Date creationDate;

    private ProfileModel profileModel;

    public UserLoggerModel() {
    }

    public UserLoggerModel(String username, String password, Date creationDate) {
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
    }

    public UserLoggerModel(String username, String password, Date creationDate, ProfileModel profileModel) {
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
        this.profileModel = profileModel;
    }

    public UserLoggerModel(Long idUserLoggerModel, String username, String password, Date creationDate, ProfileModel profileModel) {
        this.idUserLoggerModel = idUserLoggerModel;
        this.username = username;
        this.password = password;
        this.creationDate = creationDate;
        this.profileModel = profileModel;
    }

    public Long getIdUserLoggerModel() {
        return idUserLoggerModel;
    }

    public void setIdUserLoggerModel(Long idUserLoggerModel) {
        this.idUserLoggerModel = idUserLoggerModel;
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

    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

    @Override
    public String toString() {
        return username + " " + password + " [" + idUserLoggerModel + "] " + profileModel + " (" + creationDate + ")";
    }
}
