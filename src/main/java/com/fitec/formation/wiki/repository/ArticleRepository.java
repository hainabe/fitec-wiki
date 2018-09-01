package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    //    List<Article> findByStatus(Status status);
    @Query("SELECT a FROM Article as a WHERE a.status = :argStatus")
    List<Article> getArticlesByStatus(@Param(value = "argStatus") StatusModel status);

    //    List<Article> findByUser_UserLogger_Username(String username);
    @Query("SELECT a FROM Article as a WHERE a.user.userLogger.username = :argUsername")
    List<Article> getArticlesByUser(@Param(value = "argUsername") String username);

    //    List<Article> findByCreationDate_Year(String year);
    @Query("SELECT a FROM Article as a WHERE a.year = :argStrYear")
    List<Article> getArticlesByYear(@Param(value = "argStrYear") String strYear);
}
