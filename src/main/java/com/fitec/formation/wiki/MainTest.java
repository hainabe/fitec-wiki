package com.fitec.formation.wiki;

import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.entity.User;
import com.fitec.formation.wiki.service.UserService;
import com.fitec.formation.wiki.test.StatusTest;
import com.fitec.formation.wiki.test.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MainTest implements CommandLineRunner {

    @Autowired
    UserTest userTest;
    @Autowired
    UserService userService;


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainTest.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.printf("MainTest.run");

        List<User> users = userTest.initUserSuite();

        userService.addUser(users.get(0));
        userService.addUser(users.get(1));
        userService.addUser(users.get(2));
    }

}
