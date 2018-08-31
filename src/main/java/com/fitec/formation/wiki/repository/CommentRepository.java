package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByParentComment(Comment parentComment);

    List<Comment> findByUser_UserLogin_UserName(String username);

}
