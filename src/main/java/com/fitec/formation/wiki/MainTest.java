package com.fitec.formation.wiki;

import com.fitec.formation.wiki.test.ProfileTest;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainTest implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainTest.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    public void run(String... strings) throws Exception {
        System.out.println("MainTest.run");
        ProfileTest.initProfileSuite();
    }
}
