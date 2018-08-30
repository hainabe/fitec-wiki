package com.fitec.formation.wiki.service;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public boolean addUser(User u) {
        return false;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public boolean updateUser(User u) {
        return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        return false;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<User> getUsersByStatus(Status status) {
        return null;
    }

    @Override
    public List<User> getUsersByProfile(Status profile) {
        return null;
    }

    @Override
    public boolean setStatusOfArticle(Article article, Status status) {
        return false;
    }

    @Override
    public boolean setStatusOfComment(Comment comment, Status status) {
        return false;
    }

    @Override
    public boolean setStatusOfUser(User user, Status status) {
        return false;
    }

}
