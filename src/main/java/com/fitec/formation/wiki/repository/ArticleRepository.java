package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
