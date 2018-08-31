package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.UserLogger;
import com.fitec.formation.wiki.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserLoggerTest {

    @Autowired
    DateUtil dateUtil;
    @Autowired
    ProfileTest profileTest;

    public List<UserLogger> initUserLoggerSuite() {
        List<UserLogger> usersLogger = new ArrayList<>();

        final UserLogger ul01 = new UserLogger();
        ul01.setEmail("email01");
        ul01.setUsername("username01");
        ul01.setPassword("password01");
        ul01.setCreationDate(dateUtil.formatDate("01-01-2011"));
        ul01.setProfile(profileTest.initProfileSuite().get(0));
        usersLogger.add(ul01);

        final UserLogger ul02 = new UserLogger();
        ul02.setEmail("email02");
        ul02.setUsername("username02");
        ul02.setPassword("password02");
        ul02.setCreationDate(dateUtil.formatDate("02-02-2012"));
        ul02.setProfile(profileTest.initProfileSuite().get(1));
        usersLogger.add(ul02);

        final UserLogger ul03 = new UserLogger();
        ul03.setEmail("email03");
        ul03.setUsername("username03");
        ul03.setPassword("password03");
        ul03.setCreationDate(dateUtil.formatDate("03-03-2013"));
        ul03.setProfile(profileTest.initProfileSuite().get(2));
        usersLogger.add(ul03);

        System.out.println("initUserLoggerSuite() = " + !usersLogger.isEmpty());
        return usersLogger;
    }
}
