package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Profile;
import com.fitec.formation.wiki.model.ProfileModel;

public class ProfileMapper {

    public static Profile mapToProfile(ProfileModel value) {
        Profile p = new Profile();
        p.setProfile(value);
        return p;
    }

    public static ProfileModel mapToProfileModel(Profile p) {
        ProfileModel value = p.getProfile();
        return value;
    }
}
