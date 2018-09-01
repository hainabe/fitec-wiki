package com.fitec.formation.wiki;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.entity.User;
import com.fitec.formation.wiki.service.ArticleService;
import com.fitec.formation.wiki.service.CommentService;
import com.fitec.formation.wiki.service.UserService;
import com.fitec.formation.wiki.test.ArticleTest;
import com.fitec.formation.wiki.test.CommentTest;
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
    @Autowired
    ArticleTest articleTest;
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentTest commentTest;
    @Autowired
    CommentService commentService;


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainTest.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.printf("MainTest.run");

        List<User> users = userTest.initUserSuite();
        System.out.println(users);
        for (User u : users) {
            userService.addUser(u);
        }

        List<Article> articles = articleTest.initArticleSuite();
        System.out.println(articles);
        for (Article a : articles) {
            articleService.addArticle(a);
        }

        List<Comment> comments = commentTest.initCommentSuite();
        System.out.println(comments);
        for (Comment c : comments) {
            commentService.addComment(c);
        }
    }
}
