package com.fitec.formation.wiki.service;

import com.fitec.formation.wiki.entity.Comment;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    @Override
    public boolean addComment(Comment c) {
        return false;
    }

    @Override
    public Comment getComment(Long id) {
        return null;
    }

    @Override
    public boolean updateComment(Comment c) {
        return false;
    }

    @Override
    public boolean deleteComment(Long id) {
        return false;
    }

    @Override
    public List<Comment> getComments() {
        return null;
    }

    @Override
    public List<Comment> getCommentsByParent(Comment parentComment) {
        return null;
    }

    @Override
    public List<Comment> getCommentsByUser(String username) {
        return null;
    }
}
