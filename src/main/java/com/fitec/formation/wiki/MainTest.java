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
        System.out.printf("... ... ... ... MainTest.run ... ... ... ...");

        List<User> users = userTest.initUserSuite();
        for (User u : users) {
            userService.addUser(u);
            System.out.println("... USER: id = " + u.getIdUser());
        }

        List<Article> articles = articleTest.initArticleSuite();
        for (Article a : articles) {
            articleService.addArticle(a);
            System.out.println("" +
                    "... ... ARTICLE: id = " + a.getIdArticle() + " " +
                    "... A_USER: id = " + a.getUser().getIdUser());
        }

        List<Comment> comments = commentTest.initCommentSuite();
        for (Comment c : comments) {
            commentService.addComment(c);
            System.out.println("" +
                    "... ... COMMENT: id = " + c.getIdComment() + " " +
                    "... C_ARTICLE: id = " + c.getArticle().getIdArticle() + " " +
                    "... C_USER: id = " + c.getUser().getIdUser());
        }
    }
}
