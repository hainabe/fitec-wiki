package com.fitec.formation.wiki.service;

import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.repository.CommentRepository;
import com.fitec.formation.wiki.util.MessageUtil;
import com.fitec.formation.wiki.util.PropertyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PropertyUtil propertyUtil;

    @Override
    public boolean addComment(Comment c) {
        boolean result = false;
        if (Objects.nonNull(c)) {
            result = Objects.nonNull(commentRepository.save(c));
            System.out.println(MessageUtil.MSG_SUCCESS_ADD);
        } else {
            System.out.println(MessageUtil.MSG_ERROR_NULL);
        }
        return result;
    }

    @Override
    public Comment getComment(Long id) {
        Comment comment = commentRepository.getOne(id);
        return comment;
    }

    @Override
    public boolean updateComment(Comment oldC) {
        boolean result = false;
        Comment targetComment = commentRepository.getOne(oldC.getIdComment());
        if (Objects.nonNull(oldC) && commentRepository.existsById(oldC.getIdComment())) {
            BeanUtils.copyProperties(oldC, targetComment, propertyUtil.getNullPropertyNames(oldC));
            result = Objects.nonNull(commentRepository.save(targetComment));
            System.out.println(MessageUtil.MSG_SUCCESS_UPDATE);
        } else {
            System.out.println(MessageUtil.MSG_ERROR_NULL_NOT_FOUND);
        }
        return result;
    }

    @Override
    public boolean deleteComment(Long id) {
        boolean result = false;
        if (commentRepository.existsById(id)) {
            commentRepository.delete(getComment(id));
            result = true;
            System.out.println(MessageUtil.MSG_SUCCESS_DELETE);
        } else {
            System.out.println(MessageUtil.MSG_ERROR_NOT_FOUND);
        }
        return result;
    }

    @Override
    public List<Comment> getComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments;
    }

    @Override
    public List<Comment> getCommentsByParent(Comment parentComment) {
        List<Comment> comments = commentRepository.getCommentsByParent(parentComment);
        return comments;
    }

    @Override
    public List<Comment> getCommentsByUser(String username) {
        List<Comment> comments = commentRepository.getCommentsByUser(username);
        return comments;
    }
}
