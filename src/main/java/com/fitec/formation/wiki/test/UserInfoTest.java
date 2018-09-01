package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.UserInfo;
import com.fitec.formation.wiki.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserInfoTest {

    @Autowired
    DateUtil dateUtil;
    @Autowired
    AddressTest addressTest;

    public List<UserInfo> initUserInfoSuite() {
        List<UserInfo> usersInfo = new ArrayList<>();

        final UserInfo ui01 = new UserInfo();
        ui01.setFirstname("fn01");
        ui01.setLastname("ln01");
        ui01.setPhone("phone01");
        ui01.setBirthday(dateUtil.formatDate("01-01-2011"));
        ui01.setAddress(addressTest.initAddressTestSuite().get(0));
        usersInfo.add(ui01);

        final UserInfo ui02 = new UserInfo();
        ui02.setFirstname("fn02");
        ui02.setLastname("ln02");
        ui02.setPhone("phone02");
        ui02.setBirthday(dateUtil.formatDate("02-02-2012"));
        ui02.setAddress(addressTest.initAddressTestSuite().get(1));
        usersInfo.add(ui02);

        final UserInfo ui03 = new UserInfo();
        ui03.setFirstname("fn03");
        ui03.setLastname("ln03");
        ui03.setPhone("phone03");
        ui03.setBirthday(dateUtil.formatDate("03-03-2013"));
        ui03.setAddress(addressTest.initAddressTestSuite().get(2));
        usersInfo.add(ui03);

        System.out.println("initUserInfoSuite() = " + !usersInfo.isEmpty());
        return usersInfo;
    }
}
