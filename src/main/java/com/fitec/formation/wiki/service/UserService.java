package com.fitec.formation.wiki.service;

import com.fitec.formation.wiki.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    boolean addUser(User u);

    User getUser(Long id);

    User getUserByUsername(String username);

    boolean updateUser(User u);

    boolean deleteUser(Long id);

    List<User> getUsers();

    List<User> getUsersByStatus(Status status);

    List<User> getUsersByProfile(Profile profile);

    // boolean setStatusOfArticle(Article article, Status status);
    // boolean setStatusOfComment(Comment comment, Status status);
    // boolean setStatusOfUser(User user, Status status);
    boolean setStatus(Object object, Status status);
}
