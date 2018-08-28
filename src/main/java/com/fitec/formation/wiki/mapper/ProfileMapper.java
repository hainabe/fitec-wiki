package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Profile;
import com.fitec.formation.wiki.model.ProfileModel;

public class ProfileMapper {

    public static Profile mapToProfile(ProfileModel type) {
        Profile p = new Profile();
        p.setType(type.toString());
        return p;
    }

    public static ProfileModel mapToProfileModel(Profile p) {
        String type = p.getType();
        return Enum.valueOf(ProfileModel.class, type);
    }
}
