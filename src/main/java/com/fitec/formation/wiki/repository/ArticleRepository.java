package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByUser_UserLogin_UserName(String username);

    List<Article> findByStatus(Status status);

    List<Article> findByCreationDate_Year(String year);

}
