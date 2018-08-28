package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.Profile;
import com.fitec.formation.wiki.mapper.ProfileMapper;
import com.fitec.formation.wiki.model.ProfileModel;

import java.util.ArrayList;
import java.util.List;

public abstract class ProfileTest {

    public static List<Profile> initProfileSuite() {
        final List<Profile> profiles = new ArrayList<Profile>();
        profiles.add(ProfileMapper.mapToProfile(ProfileModel.ADMIN));
        profiles.add(ProfileMapper.mapToProfile(ProfileModel.MOD));
        profiles.add(ProfileMapper.mapToProfile(ProfileModel.USER));
        return profiles;
    }
}
