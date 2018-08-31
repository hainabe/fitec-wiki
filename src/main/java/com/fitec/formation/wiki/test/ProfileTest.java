package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.Profile;
import com.fitec.formation.wiki.mapper.ProfileMapper;
import com.fitec.formation.wiki.model.ProfileModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfileTest {

    public List<Profile> initProfileSuite() {
        final List<Profile> profiles = new ArrayList<>();

        profiles.add(ProfileMapper.mapToProfile(ProfileModel.ADMIN));
        profiles.add(ProfileMapper.mapToProfile(ProfileModel.MOD));
        profiles.add(ProfileMapper.mapToProfile(ProfileModel.USER));

        System.out.println("initProfileSuite() = " + !profiles.isEmpty());
        return profiles;
    }
}
