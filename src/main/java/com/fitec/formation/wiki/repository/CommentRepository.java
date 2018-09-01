package com.fitec.formation.wiki.repository;

import com.fitec.formation.wiki.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

//    List<Comment> findByParentComment(Comment parentComment);
    @Query("SELECT c FROM Comment as c WHERE c.parentComment = :argParent")
    List<Comment> getCommentsByParent(@Param(value = "argParent") Comment parentComment);

//    List<Comment> findByUser_UserLogin_UserName(String username);
    @Query("SELECT c FROM Comment as c WHERE c.user.userLogger.username = :argUsername")
    List<Comment> getCommentsByUser(@Param(value = "argUsername") String username);
}
