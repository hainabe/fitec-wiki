package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
