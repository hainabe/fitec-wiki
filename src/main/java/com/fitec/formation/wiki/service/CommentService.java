package com.fitec.formation.wiki.service;

import com.fitec.formation.wiki.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    boolean addComment(Comment c);

    Comment getComment(Long id);

    boolean updateComment(Comment c);

    boolean deleteComment(Long id);

    List<Comment> getComments();

    List<Comment> getCommentsByParent(Comment parentComment);

    List<Comment> getCommentsByUser(String username);
}
