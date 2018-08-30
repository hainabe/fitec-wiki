package com.fitec.formation.wiki.controller;

import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.mapper.CommentMapper;
import com.fitec.formation.wiki.model.CommentModel;
import com.fitec.formation.wiki.model.MessageModel;
import com.fitec.formation.wiki.service.CommentService;
import com.fitec.formation.wiki.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(path = "/comment/{id}", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getComment(@PathVariable("id") Long id) {
        Comment c = commentService.getComment(id);
        if (c != null) {
            CommentModel cm = CommentMapper.mapToCommentModel(c);
            return new ResponseEntity<>(cm, HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(JsonUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/comment", method = RequestMethod.POST) // @PostMapping
    public ResponseEntity<Object> addComment(@RequestBody CommentModel cm) {
        Comment c = CommentMapper.mapToComment(cm);
        if (commentService.addComment(c)) {
            return new ResponseEntity<>(new MessageModel(JsonUtil.MSG_SUCCESS_ADD), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(JsonUtil.MSG_ERROR_DB), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(path = "/comment/{id}", method = RequestMethod.PUT) // @PutMapping
    public ResponseEntity<Object> updateComment(@PathVariable("id") Long id,
                                                @RequestBody CommentModel cm) {
        Comment c = CommentMapper.mapToComment(cm);
        c.setIdComment(id);
        if (commentService.updateComment(c)) {
            return new ResponseEntity<>(new MessageModel(JsonUtil.MSG_SUCCESS_UPDATE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(JsonUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/comment/{id}", method = RequestMethod.DELETE) // @DeleteMapping
    public ResponseEntity<Object> deleteComment(@PathVariable("id") Long id) {
        if (commentService.deleteComment(id)) {
            return new ResponseEntity<>(new MessageModel(JsonUtil.MSG_SUCCESS_DELETE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(JsonUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/comments", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getComments() {
        List<Comment> comments = commentService.getComments();
        List<CommentModel> commentsModel = new ArrayList<>();
        for (Comment c : comments) {
            commentsModel.add(CommentMapper.mapToCommentModel(c));
        }
        return new ResponseEntity<>(commentsModel, HttpStatus.OK);
    }

    @RequestMapping(path = "/comments/{id}", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getCommentsByParent(@PathVariable("id") Long idParent) {
        Comment cParent = commentService.getComment(idParent);
        List<Comment> comments = commentService.getCommentsByParent(cParent);
        List<CommentModel> commentsModel = new ArrayList<>();
        for (Comment c : comments) {
            commentsModel.add(CommentMapper.mapToCommentModel(c));
        }
        return new ResponseEntity<>(commentsModel, HttpStatus.OK);
    }

    @RequestMapping(path = "/comments/{username}", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getCommentsByUser(@PathVariable("username") String username) {
        List<Comment> comments = commentService.getCommentsByUser(username);
        List<CommentModel> commentsModel = new ArrayList<>();
        for (Comment c : comments) {
            commentsModel.add(CommentMapper.mapToCommentModel(c));
        }
        return new ResponseEntity<>(commentsModel, HttpStatus.OK);
    }

}
