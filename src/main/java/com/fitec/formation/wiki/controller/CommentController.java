package com.fitec.formation.wiki.controller;

import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.mapper.CommentMapper;
import com.fitec.formation.wiki.model.CommentModel;
import com.fitec.formation.wiki.model.MessageModel;
import com.fitec.formation.wiki.service.CommentService;
import com.fitec.formation.wiki.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = MessageUtil.CROSS_ORIGIN)
@Controller
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comment/{id}")
    public ResponseEntity<Object> getComment(@PathVariable("id") Long id) {
        Comment c = commentService.getComment(id);
        if (c != null) {
            CommentModel cm = CommentMapper.mapToCommentModel(c);
            return new ResponseEntity<>(cm, HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/comment")
    public ResponseEntity<Object> addComment(@RequestBody CommentModel cm) {
        Comment c = CommentMapper.mapToComment(cm);
        if (commentService.addComment(c)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_ADD), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_DB), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/comment/{id}")
    public ResponseEntity<Object> updateComment(@PathVariable("id") Long id,
                                                @RequestBody CommentModel cm) {
        Comment c = CommentMapper.mapToComment(cm);
        c.setIdComment(id);
        if (commentService.updateComment(c)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_UPDATE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Object> deleteComment(@PathVariable("id") Long id) {
        if (commentService.deleteComment(id)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_DELETE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/comments")
    public ResponseEntity<Object> getComments() {
        List<Comment> comments = commentService.getComments();
        List<CommentModel> commentsModel = new ArrayList<>();
        for (Comment c : comments) {
            commentsModel.add(CommentMapper.mapToCommentModel(c));
        }
        return new ResponseEntity<>(commentsModel, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Object> getCommentsByParent(@PathVariable("id") Long idParent) {
        Comment cParent = commentService.getComment(idParent);
        List<Comment> comments = commentService.getCommentsByParent(cParent);
        List<CommentModel> commentsModel = new ArrayList<>();
        for (Comment c : comments) {
            commentsModel.add(CommentMapper.mapToCommentModel(c));
        }
        return new ResponseEntity<>(commentsModel, HttpStatus.OK);
    }

    @GetMapping("/comments/u/{username}")
    public ResponseEntity<Object> getCommentsByUser(@PathVariable("username") String username) {
        List<Comment> comments = commentService.getCommentsByUser(username);
        List<CommentModel> commentsModel = new ArrayList<>();
        for (Comment c : comments) {
            commentsModel.add(CommentMapper.mapToCommentModel(c));
        }
        return new ResponseEntity<>(commentsModel, HttpStatus.OK);
    }
}
