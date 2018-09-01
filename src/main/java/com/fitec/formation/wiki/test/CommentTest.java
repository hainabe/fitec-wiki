package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.model.StatusModel;
import com.fitec.formation.wiki.service.ArticleService;
import com.fitec.formation.wiki.service.CommentService;
import com.fitec.formation.wiki.service.UserService;
import com.fitec.formation.wiki.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentTest {

    @Autowired
    DateUtil dateUtil;
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;

    public List<Comment> initCommentSuite() {
        List<Comment> comments = new ArrayList<>();
        List<Comment> cComment1 = new ArrayList<>();
        List<Comment> cComment2 = new ArrayList<>();
        List<Comment> cComment3 = new ArrayList<>();

        /**
         * USER 1 posts ARTICLE 1, COMMENTS C1X
         */

        final Comment c11 = new Comment();
        c11.setTitle("title11");
        c11.setContent("content11");
        c11.setCreationDate(dateUtil.formatDate("01-01-2011"));
        c11.setStatus(StatusModel.STATUS_COMMENT_ENABLED);
        c11.setArticle(articleService.getArticle(1L));
        c11.setUser(userService.getUser(1L));
        c11.setParentComment(null);

        final Comment c12 = new Comment();
        c12.setTitle("title12");
        c12.setContent("content12");
        c12.setCreationDate(dateUtil.formatDate("02-02-2012"));
        c12.setStatus(StatusModel.STATUS_COMMENT_ENABLED);
        c12.setArticle(articleService.getArticle(1L));
        c12.setUser(userService.getUser(2L));
        c12.setParentComment(c11);
        c12.setChildComments(null);

        final Comment c13 = new Comment();
        c13.setTitle("title13");
        c13.setContent("content13");
        c13.setCreationDate(dateUtil.formatDate("03-03-2013"));
        c13.setStatus(StatusModel.STATUS_COMMENT_DISABLED);
        c13.setArticle(articleService.getArticle(1L));
        c13.setUser(userService.getUser(3L));
        c13.setParentComment(c11);
        c13.setChildComments(null);

        cComment1.add(c12);
        cComment1.add(c13);
        c11.setChildComments(cComment1);

        comments.add(c11);
        comments.add(c12);
        comments.add(c13);

        /**
         * USER 2 posts ARTICLE 2, COMMENTS C2X
         */

        final Comment c21 = new Comment();
        c21.setTitle("title21");
        c21.setContent("content21");
        c21.setCreationDate(dateUtil.formatDate("01-01-2011"));
        c21.setStatus(StatusModel.STATUS_COMMENT_ENABLED);
        c21.setArticle(articleService.getArticle(2L));
        c21.setUser(userService.getUser(1L));
        c21.setParentComment(null);

        final Comment c22 = new Comment();
        c22.setTitle("title22");
        c22.setContent("content22");
        c22.setCreationDate(dateUtil.formatDate("02-02-2012"));
        c22.setStatus(StatusModel.STATUS_COMMENT_ENABLED);
        c22.setArticle(articleService.getArticle(2L));
        c22.setUser(userService.getUser(2L));
        c22.setParentComment(c21);
        c22.setChildComments(null);

        final Comment c23 = new Comment();
        c23.setTitle("title23");
        c23.setContent("content23");
        c23.setCreationDate(dateUtil.formatDate("03-03-2013"));
        c23.setStatus(StatusModel.STATUS_COMMENT_DISABLED);
        c23.setArticle(articleService.getArticle(2L));
        c23.setUser(userService.getUser(3L));
        c23.setParentComment(c21);
        c23.setChildComments(null);

        cComment2.add(c22);
        cComment2.add(c23);
        c21.setChildComments(cComment2);

        comments.add(c21);
        comments.add(c22);
        comments.add(c23);

        /**
         * USER 3 posts ARTICLE 3, COMMENTS C3X
         */

        final Comment c31 = new Comment();
        c31.setTitle("title31");
        c31.setContent("content31");
        c31.setCreationDate(dateUtil.formatDate("01-01-2011"));
        c31.setStatus(StatusModel.STATUS_COMMENT_ENABLED);
        c31.setArticle(articleService.getArticle(3L));
        c31.setUser(userService.getUser(1L));
        c31.setParentComment(null);

        final Comment c32 = new Comment();
        c32.setTitle("title32");
        c32.setContent("content32");
        c32.setCreationDate(dateUtil.formatDate("02-02-2012"));
        c32.setStatus(StatusModel.STATUS_COMMENT_ENABLED);
        c32.setArticle(articleService.getArticle(3L));
        c32.setUser(userService.getUser(2L));
        c32.setParentComment(c31);
        c32.setChildComments(null);

        final Comment c33 = new Comment();
        c33.setTitle("title33");
        c33.setContent("content33");
        c33.setCreationDate(dateUtil.formatDate("03-03-2013"));
        c33.setStatus(StatusModel.STATUS_COMMENT_DISABLED);
        c33.setArticle(articleService.getArticle(3L));
        c33.setUser(userService.getUser(3L));
        c33.setParentComment(c31);
        c33.setChildComments(null);

        cComment3.add(c32);
        cComment3.add(c33);
        c31.setChildComments(cComment3);

        comments.add(c31);
        comments.add(c32);
        comments.add(c33);

        System.out.println("initCommentSuite() = " + !comments.isEmpty());
        return comments;
    }
}
