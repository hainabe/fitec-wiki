package com.fitec.formation.wiki.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fitec.formation.wiki.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoggerModel {

    private String email;
    private String username;
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = MessageUtil.DATE_PATTERN)
    private Date creationDate;

    private ProfileModel profileModel;

    public UserLoggerModel(String username, String password, Date creationDate) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return username + " " + password + " [] " + profileModel + " (" + creationDate + ")";
    }
}
