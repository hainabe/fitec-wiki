package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.User;
import com.fitec.formation.wiki.model.StatusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserTest {

    @Autowired
    UserLoggerTest userLoggerTest;
    @Autowired
    UserInfoTest userInfoTest;

    public List<User> initUserSuite() {
        List<User> users = new ArrayList<>();

        final User u01 = new User();
        u01.setUserLogger(userLoggerTest.initUserLoggerSuite().get(0));
        u01.setUserInfo(userInfoTest.initUserInfoSuite().get(0));
        u01.setStatus(StatusModel.STATUS_USER_CONNECTED);
        users.add(u01);

        final User u02 = new User();
        u02.setUserLogger(userLoggerTest.initUserLoggerSuite().get(1));
        u02.setUserInfo(userInfoTest.initUserInfoSuite().get(1));
        u02.setStatus(StatusModel.STATUS_USER_DISCONNECTED);
        users.add(u02);

        final User u03 = new User();
        u03.setUserLogger(userLoggerTest.initUserLoggerSuite().get(2));
        u03.setUserInfo(userInfoTest.initUserInfoSuite().get(2));
        u03.setStatus(StatusModel.STATUS_USER_DISABLED);
        users.add(u03);

        System.out.println("initUserSuite() = " + !users.isEmpty());
        return users;
    }
}
