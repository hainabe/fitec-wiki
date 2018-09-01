package com.fitec.formation.wiki.controller;

import com.fitec.formation.wiki.entity.*;
import com.fitec.formation.wiki.mapper.*;
import com.fitec.formation.wiki.model.*;
import com.fitec.formation.wiki.service.UserService;
import com.fitec.formation.wiki.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getUser(@PathVariable("id") Long id) {
        User u = userService.getUser(id);
        if (u != null) {
            UserModel um = UserMapper.mapToUserModel(u);
            return new ResponseEntity<>(um, HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/user/{username}", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getUser(@PathVariable("username") String username) {
        User u = userService.getUserByUsername(username);
        if (u != null) {
            UserModel um = UserMapper.mapToUserModel(u);
            return new ResponseEntity<>(um, HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST) // @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody UserModel um) {
        User u = UserMapper.mapToUser(um);
        if (userService.addUser(u)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_ADD), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_DB), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.PUT) // @PutMapping
    public ResponseEntity<Object> updateUser(@PathVariable("id") Long id,
                                             @RequestBody UserModel um) {
        User u = UserMapper.mapToUser(um);
        u.setIdUser(id);
        if (userService.updateUser(u)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_UPDATE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE) // @DeleteMapping
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
        if (userService.deleteUser(id)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_DELETE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getUsers() {
        List<User> users = userService.getUsers();
        List<UserModel> usersModel = new ArrayList<>();
        for (User u : users) {
            usersModel.add(UserMapper.mapToUserModel(u));
        }
        return new ResponseEntity<>(usersModel, HttpStatus.OK);
    }

    @RequestMapping(path = "/users/{status}", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getUsersByStatus(@PathVariable("status") String status) {
        StatusModel sm = StatusModel.getStatus(StatusModel.valueOf(status).getId());
        List<User> users = userService.getUsersByStatus(sm);
        List<UserModel> usersModel = new ArrayList<>();
        for (User u : users) {
            usersModel.add(UserMapper.mapToUserModel(u));
        }
        return new ResponseEntity<>(usersModel, HttpStatus.OK);
    }

    @RequestMapping(path = "/users/{profile}", method = RequestMethod.GET) // @GetMapping
    public ResponseEntity<Object> getUsersByProfile(@PathVariable("profile") String profile) {
        ProfileModel pm = ProfileModel.getProfile(ProfileModel.valueOf(profile).getId());
        List<User> users = userService.getUsersByProfile(pm);
        List<UserModel> usersModel = new ArrayList<>();
        for (User u : users) {
            usersModel.add(UserMapper.mapToUserModel(u));
        }
        return new ResponseEntity<>(usersModel, HttpStatus.OK);
    }

    @RequestMapping(path = "/mod/article/{id}", method = RequestMethod.PUT) // @PutMapping
    public ResponseEntity<Object> setStatusOfArticle(@PathVariable("id") Long id,
                                                     @RequestBody ArticleModel am,
                                                     @RequestBody StatusModel sm) {
        Article a = ArticleMapper.mapToArticle(am);
        a.setIdArticle(id);
        StatusModel sms = StatusModel.getStatus(sm.getId());
        if (userService.setStatus(a, sms)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_UPDATE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/mod/comment/{id}", method = RequestMethod.PUT) // @PutMapping
    public ResponseEntity<Object> setStatusOfComment(@PathVariable("id") Long id,
                                                     @RequestBody CommentModel cm,
                                                     @RequestBody StatusModel sm) {
        Comment c = CommentMapper.mapToComment(cm);
        c.setIdComment(id);
        StatusModel sms = StatusModel.getStatus(sm.getId());
        if (userService.setStatus(c, sms)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_UPDATE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/admin/user/{id}", method = RequestMethod.PUT) // @PutMapping
    public ResponseEntity<Object> setStatusOfUser(@PathVariable("id") Long id,
                                                  @RequestBody UserModel um,
                                                  @RequestBody StatusModel sm) {
        User u = UserMapper.mapToUser(um);
        u.setIdUser(id);
        StatusModel sms = StatusModel.getStatus(sm.getId());
        if (userService.setStatus(u, sms)) {
            return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_UPDATE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_ERROR_NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
