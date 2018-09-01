package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.UserLogger;
import com.fitec.formation.wiki.model.UserLoggerModel;

public class UserLoggerMapper {

    public static UserLogger mapToUserLogger(UserLoggerModel ulm) {
        UserLogger ul = new UserLogger();
        ul.setEmail(ulm.getEmail());
        ul.setUsername(ulm.getUsername());
        ul.setPassword(ulm.getPassword());
        ul.setCreationDate(ulm.getCreationDate());
        ul.setProfile(ulm.getProfileModel());
        return ul;
    }

    public static UserLoggerModel mapToUserLoggerModel(UserLogger ul) {
        UserLoggerModel ulm = new UserLoggerModel();
        ulm.setEmail(ul.getEmail());
        ulm.setUsername(ul.getUsername());
        ulm.setPassword(ul.getPassword());
        ulm.setCreationDate(ul.getCreationDate());
        ulm.setProfileModel(ul.getProfile());
        return ulm;
    }
}
